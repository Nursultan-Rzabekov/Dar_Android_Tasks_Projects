package com.example.cleanarhitecturewithmvvm.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarhitecturewithmvvm.room.dao.LanguageDao
import com.example.cleanarhitecturewithmvvm.room.model.LanguageRoomDB


@Database(entities = [LanguageRoomDB::class], version = 1, exportSchema = false)
abstract class  LanguagesDatabase : RoomDatabase() {
    abstract fun languageDao(): LanguageDao
}
