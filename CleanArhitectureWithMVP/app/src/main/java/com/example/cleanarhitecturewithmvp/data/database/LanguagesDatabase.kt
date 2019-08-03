package com.example.cleanarhitecturewithmvp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarhitecturewithmvp.data.dao.LanguageDao
import com.example.cleanarhitecturewithmvp.data.model.LanguageRoomDB
import javax.inject.Inject


@Database(entities = [LanguageRoomDB::class], version = 1, exportSchema = false)
abstract class  LanguagesDatabase : RoomDatabase() {

    abstract fun languageDao(): LanguageDao


//    companion object {
////
////        @Volatile private var INSTANCE: LanguagesDatabase? = null
////
////        fun getInstance(context: Context): LanguagesDatabase =
////                INSTANCE ?: synchronized(this) {
////                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
////                }
////
////        private fun buildDatabase(context: Context) =
////                Room.databaseBuilder(context.applicationContext,
////                        LanguagesDatabase::class.java, "sample_data11_database.db")
////                        .build()
////    }
}
