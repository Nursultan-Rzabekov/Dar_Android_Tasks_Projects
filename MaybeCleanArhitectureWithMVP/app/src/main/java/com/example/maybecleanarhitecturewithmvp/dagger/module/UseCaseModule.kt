package com.example.maybecleanarhitecturewithmvp.dagger.module

import com.example.maybecleanarhitecturewithmvp.domain.repository.IRoomRepository
import com.example.maybecleanarhitecturewithmvp.domain.usecase.delete.DeleteAllLanguageUseCase
import com.example.maybecleanarhitecturewithmvp.domain.usecase.delete.DeleteLanguageUseCase
import com.example.maybecleanarhitecturewithmvp.domain.usecase.get.GetLanguageByIdUseCase
import com.example.maybecleanarhitecturewithmvp.domain.usecase.get.GetLanguageUseCase
import com.example.maybecleanarhitecturewithmvp.domain.usecase.insert.InsertAllLanguageUseCase
import com.example.maybecleanarhitecturewithmvp.domain.usecase.insert.InsertLanguageUseCase
import com.example.maybecleanarhitecturewithmvp.domain.usecase.update.UpdateLanguageUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetLanguagebyIdUseCase(iRoomRepository: IRoomRepository): GetLanguageByIdUseCase {
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