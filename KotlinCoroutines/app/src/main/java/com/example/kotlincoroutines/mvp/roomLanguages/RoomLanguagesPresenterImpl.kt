package com.example.kotlincoroutines.mvp.roomLanguages


import com.example.kotlincoroutines.data.LanguageRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class RoomLanguagesPresenterImpl(var postViewI: IRoomLanguagesView, var viewModel: RoomRepository,
                                 override val coroutineContext: CoroutineContext
): IRoomLanguagesPresenter,CoroutineScope{

    override suspend fun getByLanguageID(position: Int) {
        viewModel.getByLanguageID(position)
    }

    override fun getAllLanguage() =
        this.launch(coroutineContext){
            viewModel.getAllLanguage()
            postViewI.showAllLanguage(viewModel.getAllLanguage())
        }

    override suspend fun storeLanguageAll(languageList: ArrayList<LanguageRoomDB>?) {
        viewModel.storeAllLanguage(languageList)
    }

    override fun storeLanguage(language: String) {
        this.launch(coroutineContext){
            val roomDB = LanguageRoomDB(language)
            viewModel.storeLanguage(language)
            postViewI.storeLanguage(roomDB)
        }
    }

    override fun updateLanguageName(position: Int,language_name: String) {
        this.launch(coroutineContext){
            val roomDB = LanguageRoomDB(language_name)
            viewModel.updateLanguageName(position,language_name)
            postViewI.updateLanguage(position,roomDB)
        }
    }

    override fun deleteAllLanguage() {
        this.launch(coroutineContext){
            viewModel.deleteAllLanguageById()
            postViewI.deleteLanguage()
        }
    }

    override fun deleteLanguageByID(position: Int) {
        this.launch(coroutineContext){
            viewModel.deleteLanguageID(position)
            postViewI.deleteLanguageByLanguageID(position)
        }
    }
}

