package com.example.cleanarhitecturewithmvp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarhitecturewithmvp.data.dao.LanguageDao
import com.example.cleanarhitecturewithmvp.data.model.LanguageRoomDB


@Database(entities = [LanguageRoomDB::class], version = 1, exportSchema = false)
abstract class  LanguagesDatabase : RoomDatabase() {
    abstract fun languageDao(): LanguageDao
}
