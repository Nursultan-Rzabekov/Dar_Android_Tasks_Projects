package com.example.cleanarhitecturewithmvvm.dagger.module


import com.example.cleanarhitecturewithmvvm.data.repository.LanguageRemote
import com.example.cleanarhitecturewithmvvm.data.repository.LanguageRoom
import com.example.cleanarhitecturewithmvvm.data.source.LanguageDataStoreFactory
import com.example.cleanarhitecturewithmvvm.data.source.LanguageRemoteDataStore
import com.example.cleanarhitecturewithmvvm.data.source.LanguageRoomDataStore
import dagger.Module
import dagger.Provides
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
                                        languageRemoteDataStore: LanguageRemoteDataStore): LanguageDataStoreFactory {
        return LanguageDataStoreFactory(languageRoom,languageRoomDataStore,languageRemoteDataStore)
    }
}