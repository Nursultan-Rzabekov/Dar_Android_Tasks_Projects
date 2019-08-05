package com.example.retrofitkotlin.roomdb.dao



import androidx.room.*
import com.example.retrofitkotlin.data.LanguageRoomDB
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import java.text.ParsePosition

@Dao
interface LanguageDao {

    @Query("SELECT * FROM languages_data_database WHERE language_id = :id")
    fun getLanguageById(id: Int): Flowable<LanguageRoomDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLanguage(language: LanguageRoomDB): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLanguage(language_list: List<LanguageRoomDB>):Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateLanguage(language: LanguageRoomDB): Completable

    @Query("SELECT * FROM languages_data_database ORDER BY language_id ASC")
    fun getAllChapter(): Flowable<List<LanguageRoomDB>>

    @Query("DELETE FROM languages_data_database")
    fun deleteAllLanguage()

    @Query("DELETE FROM languages_data_database WHERE language_id = :id")
    fun deleteLanguageByID(id:Int)

}