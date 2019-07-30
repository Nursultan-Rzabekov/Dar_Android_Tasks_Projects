package com.example.kotlincoroutines.mvp.roomLanguages


import com.example.kotlincoroutines.data.LanguageRoomDB


class RoomLanguagesPresenterImpl(var postViewI: IRoomLanguagesView, var viewModel: RoomRepository): IRoomLanguagesPresenter{

    override suspend fun getByLanguageID(position: Int) {
        viewModel.getByLanguageID(position)
    }

    override suspend fun getAllLanguage() {
        viewModel.getAllLanguage()
        postViewI.showAllLanguage(viewModel.getAllLanguage())
    }

    override suspend fun storeLanguageAll(languageList: ArrayList<LanguageRoomDB>?) {
        viewModel.storeAllLanguage(languageList)
    }

    override fun storeLanguage(language: String) {
        val roomDB = LanguageRoomDB(language)
        viewModel.storeLanguage(language)
        postViewI.storeLanguage(roomDB)
    }

    override fun updateLanguageName(position: Int,language_name: String) {
        val roomDB = LanguageRoomDB(language_name)
        viewModel.updateLanguageName(position,language_name)
        postViewI.updateLanguage(position,roomDB)
    }

    override fun deleteAllLanguage() {
        viewModel.deleteAllLanguageById()
        postViewI.deleteLanguage()
    }

    override fun deleteLanguageByID(position: Int) {
        viewModel.deleteLanguageID(position)
        postViewI.deleteLanguageByLanguageID(position)
    }
}

