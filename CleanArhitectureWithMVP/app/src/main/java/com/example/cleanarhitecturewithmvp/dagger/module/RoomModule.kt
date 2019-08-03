package com.example.cleanarhitecturewithmvp.dagger.module

import android.app.Application
import androidx.room.Room
import com.example.cleanarhitecturewithmvp.data.dao.LanguageDao
import com.example.cleanarhitecturewithmvp.data.database.LanguagesDatabase
import com.example.cleanarhitecturewithmvp.data.mapper.LanguageModelConverter
import com.example.cleanarhitecturewithmvp.data.mapper.LanguageModelConverterImpl
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
    fun provideLanguageModelConverter(): LanguageModelConverter {
        return LanguageModelConverterImpl()
    }

}