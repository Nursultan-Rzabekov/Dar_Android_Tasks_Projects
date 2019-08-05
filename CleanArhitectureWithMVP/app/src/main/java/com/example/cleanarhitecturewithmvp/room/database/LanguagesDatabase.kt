package com.example.cleanarhitecturewithmvp.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarhitecturewithmvp.room.dao.LanguageDao
import com.example.cleanarhitecturewithmvp.room.model.LanguageRoomDB


@Database(entities = [LanguageRoomDB::class], version = 1, exportSchema = false)
abstract class  LanguagesDatabase : RoomDatabase() {
    abstract fun languageDao(): LanguageDao
}
