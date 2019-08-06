package com.example.cleanarhitecturewithmvvm.mvvm.logic


import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarhitecturewithmvvm.ApplicationClass
import com.example.cleanarhitecturewithmvvm.domain.model.Language
import com.example.cleanarhitecturewithmvvm.domain.usecase.delete.DeleteLanguageUseCase
import com.example.cleanarhitecturewithmvvm.domain.usecase.get.GetLanguageUseCase
import com.example.cleanarhitecturewithmvvm.domain.usecase.insert.InsertAllLanguageUseCase
import com.example.cleanarhitecturewithmvvm.domain.usecase.insert.InsertLanguageUseCase
import com.example.cleanarhitecturewithmvvm.domain.usecase.update.UpdateLanguageUseCase
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class LanguagesViewModel(applicationComponent: Application): CoroutineScope, ViewModel() {

    @Inject
    lateinit var provideGetLanguageUseCase: GetLanguageUseCase

    @Inject
    lateinit var provideDeleteLanguageUseCase: DeleteLanguageUseCase

    @Inject
    lateinit var provideInsertAllLanguageUseCase: InsertAllLanguageUseCase

    @Inject
    lateinit var provideInsertLanguageUseCase: InsertLanguageUseCase

    @Inject
    lateinit var provideUpdateLanguageUseCase: UpdateLanguageUseCase


    var languagesList: MutableLiveData<List<Language>> = MutableLiveData()

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    private var viewModelJob = Job()
    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Main

    fun getAllLanguage() =
        this.launch(coroutineContext){
            languagesList.value = provideGetLanguageUseCase.execute()
        }

//    fun storeLanguageAll(languageList: ArrayList<Language>?) {
//        this.launch(coroutineContext){
//            provideInsertAllLanguageUseCase.execute(languageList)
//        }
//    }

    fun storeLanguage(store: String) {
        this.launch(coroutineContext){
            provideInsertLanguageUseCase.execute(store)
        }
    }

    fun updateLanguageName(position: Int,language_name: String) {
        this.launch(coroutineContext){
            provideUpdateLanguageUseCase.execute(position,language_name)
        }
    }

    fun deleteLanguageByID(position: Int) {
        this.launch(coroutineContext){
            provideDeleteLanguageUseCase.execute(position)
        }
    }

    internal fun onDestroy(){
        coroutineContext.cancel()
    }
}

