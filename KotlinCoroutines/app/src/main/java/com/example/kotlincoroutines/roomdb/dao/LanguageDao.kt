package com.example.kotlincoroutines.roomdb.dao

import androidx.room.*
import com.example.kotlincoroutines.data.LanguageRoomDB



@Dao
interface LanguageDao {

    @Query("SELECT * FROM languages_data_database WHERE language_id = :id")
    suspend fun getLanguageById(id: Int): LanguageRoomDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage(language: LanguageRoomDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLanguage(language_list: ArrayList<LanguageRoomDB>?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLanguage(language: LanguageRoomDB)

    @Query("SELECT * FROM languages_data_database ORDER BY language_id ASC")
    fun getAllLanguage(): List<LanguageRoomDB>

    @Query("DELETE FROM languages_data_database")
    suspend fun deleteAllLanguage()

    @Query("DELETE FROM languages_data_database WHERE language_id = :id")
    suspend fun deleteLanguageByID(id:Int)

}