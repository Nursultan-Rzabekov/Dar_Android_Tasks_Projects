package com.example.kotlinarhitecturecomponents.dagger.module


import com.example.kotlinarhitecturecomponents.data.repository.LanguageRemote
import com.example.kotlinarhitecturecomponents.data.repository.LanguageRoom
import com.example.kotlinarhitecturecomponents.data.source.LanguageDataStoreFactory
import com.example.kotlinarhitecturecomponents.data.source.LanguageRemoteDataStore
import com.example.kotlinarhitecturecomponents.data.source.LanguageRoomDataStore
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton




@Module
class DataModule {

    @Provides
    @Singleton
    fun provideLanguageRoomDataStore(languageRoom: LanguageRoom): LanguageRoomDataStore {
        return LanguageRoomDataStore(languageRoom)
    }

    @Provides
    @Singleton
    fun provideLanguageRemoteDataStore(languageRemote: LanguageRemote): LanguageRemoteDataStore {
        return LanguageRemoteDataStore(languageRemote)
    }

    @Provides
    @Singleton
    fun provideLanguageDataStoreFactory(languageRoom: LanguageRoom,
                                        languageRoomDataStore: LanguageRoomDataStore,
                                        languageRemoteDataStore: LanguageRemoteDataStore,
                                        compositeDisposable: CompositeDisposable): LanguageDataStoreFactory {
        return LanguageDataStoreFactory(languageRoom,languageRoomDataStore,languageRemoteDataStore,compositeDisposable)
    }
}