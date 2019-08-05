package com.example.cleanarhitecturewithmvp.dagger.module

import com.example.cleanarhitecturewithmvp.data.mapper.LanguageModelConverter
import com.example.cleanarhitecturewithmvp.data.DataRepositoryImpl
import com.example.cleanarhitecturewithmvp.data.mapper.LanguageModelConverterImpl
import com.example.cleanarhitecturewithmvp.data.source.LanguageDataStoreFactory
import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.usecase.delete.DeleteLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.get.GetLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.insert.InsertAllLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.insert.InsertLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.update.UpdateLanguageUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideLanguageModelConverter(): LanguageModelConverter {
        return LanguageModelConverterImpl()
    }

    @Provides
    @Singleton
    fun provideRoomRepository(languageDataStoreFactory: LanguageDataStoreFactory, languageModelConverter: LanguageModelConverter): IRoomRepository {
        return DataRepositoryImpl(languageDataStoreFactory, languageModelConverter)
    }


    @Provides
    @Singleton
    fun provideGetLanguageUseCase(iRoomRepository: IRoomRepository): GetLanguageUseCase {
        return GetLanguageUseCase(iRoomRepository)
    }


    @Provides
    @Singleton
    fun provideDeleteLanguageUseCase(iRoomRepository: IRoomRepository): DeleteLanguageUseCase {
        return DeleteLanguageUseCase(iRoomRepository)
    }




    @Provides
    @Singleton
    fun provideInsertLanguageUseCase(iRoomRepository: IRoomRepository): InsertLanguageUseCase {
        return InsertLanguageUseCase(iRoomRepository)
    }


    @Provides
    @Singleton
    fun provideInsertAllLanguageUseCase(iRoomRepository: IRoomRepository): InsertAllLanguageUseCase {
        return InsertAllLanguageUseCase(iRoomRepository)
    }


    @Provides
    @Singleton
    fun provideUpdateLanguageUseCase(iRoomRepository: IRoomRepository): UpdateLanguageUseCase {
        return UpdateLanguageUseCase(iRoomRepository)
    }
}