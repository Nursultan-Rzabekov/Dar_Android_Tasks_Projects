package com.example.cleanarhitecturewithmvvm.dagger.module

import android.app.Application
import androidx.room.Room
import com.example.cleanarhitecturewithmvvm.room.dao.LanguageDao
import com.example.cleanarhitecturewithmvvm.room.database.LanguagesDatabase
import com.example.cleanarhitecturewithmvvm.data.repository.LanguageRoom
import com.example.cleanarhitecturewithmvvm.room.LanguageRoomImpl
import com.example.cleanarhitecturewithmvvm.room.mapper.RoomModelConverter
import com.example.cleanarhitecturewithmvvm.room.mapper.RoomModelConverterImpl
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