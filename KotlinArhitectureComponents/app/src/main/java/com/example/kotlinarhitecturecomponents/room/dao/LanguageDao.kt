package com.example.kotlinarhitecturecomponents.room.dao

import androidx.room.*
import com.example.kotlinarhitecturecomponents.room.model.LanguageRoomDB


@Dao
interface LanguageDao {

    @Query("SELECT * FROM languages_data_database WHERE language_id = :id")
    suspend fun getLanguageById(id: Int): LanguageRoomDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage(languageDb: LanguageRoomDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLanguage(language_list: List<LanguageRoomDB>?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLanguage(language: LanguageRoomDB)

    @Query("SELECT * FROM languages_data_database ORDER BY language_id ASC")
    suspend fun getAllLanguage(): List<LanguageRoomDB>

    @Query("DELETE FROM languages_data_database")
    suspend fun deleteAllLanguage()

    @Query("DELETE FROM languages_data_database WHERE language_id = :id")
    suspend fun deleteLanguageByID(id:Int)

}