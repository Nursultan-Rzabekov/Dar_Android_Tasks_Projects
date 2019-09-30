package com.example.kotlincoroutines.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class AuthModel private constructor(`in`: Parcel) : Parcelable {

    private val clientId: String?
    private val clientSecret: String?
    private val redirectUri: String?
    private val scopes: List<String>?
    private val state: String?
    private val note: String?
    private val noteUrl: String?
    @SerializedName("X-GitHub-OTP")
    private val otpCode: String?

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.clientId)
        dest.writeString(this.clientSecret)
        dest.writeString(this.redirectUri)
        dest.writeStringList(this.scopes)
        dest.writeString(this.state)
        dest.writeString(this.note)
        dest.writeString(this.noteUrl)
        dest.writeString(this.otpCode)
    }

    init {
        this.clientId = `in`.readString()
        this.clientSecret = `in`.readString()
        this.redirectUri = `in`.readString()
        this.scopes = `in`.createStringArrayList()
        this.state = `in`.readString()
        this.note = `in`.readString()
        this.noteUrl = `in`.readString()
        this.otpCode = `in`.readString()
    }

    companion object {
        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<AuthModel> = object : Parcelable.Creator<AuthModel> {
            override fun createFromParcel(source: Parcel): AuthModel {
                return AuthModel(source)
            }
            override fun newArray(size: Int): Array<AuthModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}
