package com.example.cleanarhitecturewithmvp.dagger.module

import android.app.Application
import androidx.room.Room
import com.example.cleanarhitecturewithmvp.room.dao.LanguageDao
import com.example.cleanarhitecturewithmvp.room.database.LanguagesDatabase
import com.example.cleanarhitecturewithmvp.data.repository.LanguageRoom
import com.example.cleanarhitecturewithmvp.room.LanguageRoomImpl
import com.example.cleanarhitecturewithmvp.room.mapper.RoomModelConverter
import com.example.cleanarhitecturewithmvp.room.mapper.RoomModelConverterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class RoomModule {

    @Volatile private var INSTANCE: LanguagesDatabase? = null

    @Provides
    @Singleton
    fun getInstance(application: Application): LanguagesDatabase = INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(application).also { INSTANCE = it
                    }
                }


    private fun buildDatabase(application: Application) = Room.databaseBuilder(application,
                        LanguagesDatabase::class.java, "sample_data_database.db")
                        .build()


    @Provides
    @Singleton
    fun provideLanguageDao(languagesDatabase: LanguagesDatabase): LanguageDao {
        return languagesDatabase.languageDao()
    }


    @Provides
    @Singleton
    fun provideRoomModelConverter(): RoomModelConverter {
        return RoomModelConverterImpl()
    }

    @Provides
    @Singleton
    fun provideRoomLanguageRepository(languageDao: LanguageDao, roomModelConverter: RoomModelConverter): LanguageRoom {
        return LanguageRoomImpl(languageDao, roomModelConverter)
    }
}