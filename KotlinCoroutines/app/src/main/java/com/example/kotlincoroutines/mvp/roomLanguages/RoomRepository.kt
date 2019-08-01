package com.example.kotlincoroutines.mvp.roomLanguages


import com.example.kotlincoroutines.RemoteDataNotFoundException
import com.example.kotlincoroutines.ReposRefreshError
import com.example.kotlincoroutines.data.LanguageRoomDB
import com.example.kotlincoroutines.roomdb.dao.LanguageDao
import kotlinx.coroutines.*
import java.util.ArrayList

class RoomRepository(private val dataSource: LanguageDao): IRoomRepository{

    override suspend fun getByLanguageID(position: Int): String? {
        return try {
            withContext(Dispatchers.IO) {
                dataSource.getLanguageById(position).languageName
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }

    override suspend fun getAllLanguage() : List<LanguageRoomDB> {
        return try {
            withContext(Dispatchers.IO) {
                dataSource.getAllLanguage()
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }

    override suspend fun storeLanguage(language_name: String) {
        try {
            withContext(Dispatchers.IO){
                val language = LanguageRoomDB(language_name)
                dataSource.insertLanguage(language)
            }
        }catch (error: RemoteDataNotFoundException){
            throw ReposRefreshError(error)
        }
    }

    override suspend fun storeAllLanguage(languagelist: ArrayList<LanguageRoomDB>?) {
        try {
            withContext(Dispatchers.Default){
                dataSource.insertAllLanguage(languagelist)
            }
        } catch (error: RemoteDataNotFoundException){
            throw ReposRefreshError(error)
        }
    }

    override suspend fun updateLanguageName(position: Int, language_name: String) {
        try {
            withContext(Dispatchers.IO){
                val language = LanguageRoomDB(position+1, language_name)
                dataSource.updateLanguage(language)
            }
        }catch (error: RemoteDataNotFoundException){
            throw ReposRefreshError(error)
        }
    }

    override suspend fun deleteLanguageID(position: Int) {
        try {
            withContext(Dispatchers.IO){
                dataSource.deleteLanguageByID(position+1)
            }
        }catch (error: RemoteDataNotFoundException){
            throw ReposRefreshError(error)
        }
    }

    override suspend fun deleteAllLanguageById() {
        try {
            withContext(Dispatchers.Default){
                dataSource.deleteAllLanguage()
            }
        }
        catch (error: RemoteDataNotFoundException){
            throw ReposRefreshError(error)
        }
    }
}

