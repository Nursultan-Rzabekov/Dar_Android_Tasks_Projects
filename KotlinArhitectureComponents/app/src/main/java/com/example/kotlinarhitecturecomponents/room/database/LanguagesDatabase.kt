package com.example.kotlinarhitecturecomponents.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinarhitecturecomponents.room.dao.LanguageDao
import com.example.kotlinarhitecturecomponents.room.model.LanguageRoomDB


@Database(entities = [LanguageRoomDB::class], version = 1, exportSchema = false)
abstract class  LanguagesDatabase : RoomDatabase() {
    abstract fun languageDao(): LanguageDao
}
