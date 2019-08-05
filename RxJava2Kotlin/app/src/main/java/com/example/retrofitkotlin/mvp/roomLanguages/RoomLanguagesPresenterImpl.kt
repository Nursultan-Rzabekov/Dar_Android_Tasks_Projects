package com.example.retrofitkotlin.mvp.roomLanguages

import android.content.ContentValues.TAG
import android.util.Log
import com.example.retrofitkotlin.data.LanguageRoomDB
import com.example.retrofitkotlin.mvp.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomLanguagesPresenterImpl(var postViewI: IRoomLanguagesView, var viewModel: RoomLanguagesViewModel): IRoomLanguagesPresenter, Presenter<IRoomLanguagesView>(postViewI)  {

    override fun getByLanguageID() {
    }

    override fun getAllLanguage() {
       addDisposable(viewModel.getAllLanguage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    postViewI.showAllLanguage(result)
                },
                {
                        error -> Log.e(TAG, "Unable to get username", error)
                }
            ))

    }

    override fun storeLanguageAll(languageList: List<LanguageRoomDB>) {
        addDisposable(viewModel.storeAllLanguage(languageList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                },
                {
                        error -> Log.e(TAG, "Unable to update username", error)
                }
            ))
    }

    override fun storeLanguage(language: String) {
        val roomDB = LanguageRoomDB(0,language)
        addDisposable(viewModel.storeLanguage(language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    postViewI.storeLanguage(roomDB)
                },
                {
                        error -> Log.e(TAG, "Unable to store language_name", error)
                }
            ))


    }

    override fun updateLanguageName(position: Int,language_name: String) {
        addDisposable(viewModel.updateLanguageName(position,language_name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                },
                {
                        error -> Log.e(TAG, "Unable to update username", error)
                }
            ))
    }

    override fun deleteLanguage(position: Int) {
    }

    override fun deleteLanguageByID(position: Int) {
        //viewModel.deleteLanguageID(position)
        postViewI.deleteLanguageByLanguageID(position)
    }
}

