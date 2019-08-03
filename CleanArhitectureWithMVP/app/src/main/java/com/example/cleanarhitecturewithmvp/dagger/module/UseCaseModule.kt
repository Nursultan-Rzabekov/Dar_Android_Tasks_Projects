package com.example.cleanarhitecturewithmvp.dagger.module

import com.example.cleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.cleanarhitecturewithmvp.domain.usecase.delete.DeleteAllLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.delete.DeleteLanguageUseCase
import com.example.cleanarhitecturewithmvp.domain.usecase.get.GetLanguageByIdUseCase
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
    fun provideGetLanguageByIdUseCase(iRoomRepository: IRoomRepository): GetLanguageByIdUseCase {
        return GetLanguageByIdUseCase(iRoomRepository)
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
    fun provideDeleteAllLanguageUseCase(iRoomRepository: IRoomRepository): DeleteAllLanguageUseCase {
        return DeleteAllLanguageUseCase(iRoomRepository)
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