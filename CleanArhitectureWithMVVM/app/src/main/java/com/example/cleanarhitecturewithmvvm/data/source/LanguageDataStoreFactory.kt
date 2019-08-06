package com.example.cleanarhitecturewithmvvm.data.source

import com.example.cleanarhitecturewithmvvm.data.repository.LanguageDataStore
import com.example.cleanarhitecturewithmvvm.data.repository.LanguageRoom


class LanguageDataStoreFactory (private val languageRoom: LanguageRoom,
                                private val languageRoomDataStore: LanguageRoomDataStore,
                                private val languageRemoteDataStore: LanguageRemoteDataStore) {

    suspend fun retrieveDataStore(): LanguageDataStore {
        if (!languageRoom.isCached()) {
            return retrieveRoomDataStore()
        }
        return retrieveRemoteDataStore()
    }

    internal fun retrieveRoomDataStore(): LanguageDataStore {
        return languageRoomDataStore
    }

    private fun retrieveRemoteDataStore(): LanguageDataStore {
        return languageRemoteDataStore
    }

}