package com.example.kotlincoroutines.mvp.roomLanguages


import com.example.kotlincoroutines.data.LanguageRoomDB
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class RoomLanguagesPresenterImpl(var postViewI: IRoomLanguagesView, var viewModel: RoomRepository): IRoomLanguagesPresenter, CoroutineScope{

    private var viewModelJob = Job()
    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Main

    override fun getByLanguageID(position: Int) {
        this.launch(coroutineContext){
            viewModel.getByLanguageID(position)
        }
    }

    override fun getAllLanguage() =
        this.launch(coroutineContext){
            postViewI.showAllLanguage(viewModel.getAllLanguage())
        }

    override fun storeLanguageAll(languageList: ArrayList<LanguageRoomDB>?) {
        this.launch(coroutineContext){
            viewModel.storeAllLanguage(languageList)
        }
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

    internal fun onDestroy(){
        coroutineContext.cancel()
    }
}

