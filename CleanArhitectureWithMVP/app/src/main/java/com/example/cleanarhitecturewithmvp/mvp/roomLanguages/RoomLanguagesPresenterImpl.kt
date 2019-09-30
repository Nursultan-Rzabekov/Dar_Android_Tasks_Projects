package com.example.cleanarhitecturewithmvp.mvp.roomLanguages


import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.domain.usecase.delete.DeleteLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.get.GetLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.insert.InsertAllLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.insert.InsertLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.update.UpdateLanguageUseCase
import com.example.cleanarhitecturewithmvp.mvp.BasePresenter
import kotlinx.coroutines.*
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject


@InjectViewState
class RoomLanguagesPresenterImpl @Inject constructor(
    private val getLanguageUseCase:GetLanguageUseCase)
    : BasePresenter<IRoomLanguagesView>() {


//    @Inject
//    lateinit var provideDeleteLanguageUseCase: DeleteLanguageUseCase
//
//    @Inject
//    lateinit var provideInsertAllLanguageUseCase: InsertAllLanguageUseCase
//
//    @Inject
//    lateinit var provideInsertLanguageUseCase: InsertLanguageUseCase
//
//    @Inject
//    lateinit var provideUpdateLanguageUseCase: UpdateLanguageUseCase


    fun getAllLanguage() =
        this.launch(coroutineContext){
            getLanguageUseCase.execute {
                onComplete {
                    Timber.e("onComplete: %s", it.size)
                    viewState.showAllLanguage(it)
                }

                onNetworkError {
                    //Timber.e(it)
                }
                onError {
                    Timber.e(it)
                }
            }
        }

//    fun storeLanguageAll(languageList: ArrayList<Language>?) {
//        this.launch(coroutineContext){
//            provideInsertAllLanguageUseCase.execute(languageList)
//        }
//    }
//
//    fun storeLanguage(store: String) {
//        this.launch(coroutineContext){
//            val language = Language(store)
//            provideInsertLanguageUseCase.execute(store)
//            viewState.storeLanguage(language)
//        }
//    }
//
//    fun updateLanguageName(position: Int,language_name: String) {
//        this.launch(coroutineContext){
//            val language = Language(language_name)
//            provideUpdateLanguageUseCase.execute(position,language_name)
//            viewState.updateLanguage(position,language)
//        }
//    }
//
//    fun deleteLanguageByID(position: Int) {
//        this.launch(coroutineContext){
//            provideDeleteLanguageUseCase.execute(position)
//            viewState.deleteLanguageByLanguageID(position)
//        }
//    }

    override fun onDestroy(){
        coroutineContext.cancel()
    }

}

