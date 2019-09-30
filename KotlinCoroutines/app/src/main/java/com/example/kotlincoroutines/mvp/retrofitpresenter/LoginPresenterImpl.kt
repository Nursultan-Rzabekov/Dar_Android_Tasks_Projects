package com.example.kotlincoroutines.mvp.retrofitpresenter

import android.net.Uri
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.example.kotlincoroutines.BuildConfig
import com.example.kotlincoroutines.data.AccessTokenModel
import com.example.kotlincoroutines.data.AuthModel
import okhttp3.Credentials
import java.util.*

class LoginPresenterImpl {


    fun onTokenResponse(@Nullable modelResponse: AccessTokenModel?) {
        if (modelResponse != null) {
            val token =
                if (modelResponse!!.getToken() != null) modelResponse!!.getToken() else modelResponse!!.getAccessToken()
            if (!InputHelper.isEmpty(token)) {
                PrefGetter.setToken(token)
                makeRestCall(RestProvider.getUserService(false).getUser(), ???({ this.onUserResponse(it) }))
                return
            }
        }
        sendToView { view -> view.showMessage(R.string.error, R.string.failed_login) }
    }


    @NonNull
    fun getAuthorizationUrl(): Uri {
        return Uri.Builder().scheme("https")
            .authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter("client_id", GithubConfigHelper.getClientId())
            .appendQueryParameter("redirect_uri", GithubConfigHelper.getRedirectUrl())
            .appendQueryParameter("scope", "user,repo,gist,notifications,read:org")
            .appendQueryParameter("state", BuildConfig.APPLICATION_ID)
            .build()
    }

    fun login(@NonNull username: String, @NonNull password: String, @Nullable twoFactorCode: String,
              isBasicAuth: Boolean, @Nullable endpoint: String
    ) {
        val usernameIsEmpty = InputHelper.isEmpty(username)
        val passwordIsEmpty = InputHelper.isEmpty(password)
        val endpointIsEmpty = InputHelper.isEmpty(endpoint) && isEnterprise()
        if (getView() == null) return
        getView().onEmptyUserName(usernameIsEmpty)
        getView().onEmptyPassword(passwordIsEmpty)
        getView().onEmptyEndpoint(endpointIsEmpty)
        if (!usernameIsEmpty && !passwordIsEmpty) {
            try {
                val authToken = Credentials.basic(username, password)
                if (isBasicAuth && !isEnterprise()) {
                    val authModel = AuthModel()
                    authModel.setScopes(Arrays.asList<T>("user", "repo", "gist", "notifications", "read:org"))
                    authModel.Note(BuildConfig.APPLICATION_ID)
                    authModel.setClientSecret(GithubConfigHelper.getSecret())
                    authModel.setClientId(GithubConfigHelper.getClientId())
                    authModel.setNoteUrl(GithubConfigHelper.getRedirectUrl())
                    if (!InputHelper.isEmpty(twoFactorCode)) {
                        authModel.setOtpCode(twoFactorCode)
                    }
                    makeRestCall(
                        LoginProvider.getLoginRestService(
                            authToken,
                            twoFactorCode,
                            null
                        ).login(authModel)
                    ) { accessTokenModel ->
                        if (!InputHelper.isEmpty(twoFactorCode)) {
                            PrefGetter.setOtpCode(twoFactorCode)
                        }
                        onTokenResponse(accessTokenModel)
                    }
                } else {
                    accessTokenLogin(password, endpoint, twoFactorCode, authToken)
                }
            } catch (e: Exception) {
                sendToView { view -> view.showMessage("Error", "The app was about to crash!!(" + e.message + ")") }
            }

        }
    }

    private fun accessTokenLogin(
        @NonNull password: String, @Nullable endpoint: String, @Nullable otp: String,
        @NonNull authToken: String
    ) {
        makeRestCall(
            LoginProvider.getLoginRestService(authToken, otp, endpoint).loginAccessToken()
        ) { login ->
            if (!isEnterprise()) {
                PrefGetter.setToken(password)
            } else {
                PrefGetter.setEnterpriseOtpCode(otp)
                PrefGetter.setTokenEnterprise(authToken)
                PrefGetter.setEnterpriseUrl(endpoint)
            }
            onUserResponse(login)
        }
    }
}