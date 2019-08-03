package com.example.cleanarhitecturewithmvp.data.repository



import com.example.cleanarhitecturewithmvp.RemoteDataNotFoundException
import com.example.cleanarhitecturewithmvp.ReposRefreshError
import com.example.cleanarhitecturewithmvp.data.dao.LanguageDao
import com.example.cleanarhitecturewithmvp.data.mapper.LanguageModelConverter
import com.example.cleanarhitecturewithmvp.data.model.LanguageRoomDB
import com.example.cleanarhitecturewithmvp.domain.model.Language
import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import kotlinx.coroutines.*

class RoomRepository(private val dataSource: LanguageDao,private val languageModelConverter: LanguageModelConverter): IRoomRepository {

    override suspend fun getByLanguageID(position: Int): String? {
        return try {
            withContext(Dispatchers.IO) {
                dataSource.getLanguageById(position).languageName
            }
        }catch (error: RemoteDataNotFoundException){
            throw  ReposRefreshError(error)
        }
    }

    override suspend fun getAllLanguage() : List<Language> {
        return try {
            withContext(Dispatchers.IO) {
                dataSource.getAllLanguage().map(languageModelConverter::modelToDomain)
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

    override suspend fun storeAllLanguage(languagelist: List<Language>?) {
        try {
            withContext(Dispatchers.Default){
                dataSource.insertAllLanguage(languagelist?.map(languageModelConverter::apiToModel))
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

