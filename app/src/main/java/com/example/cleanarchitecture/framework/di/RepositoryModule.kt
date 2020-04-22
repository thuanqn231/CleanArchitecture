package com.example.cleanarchitecture.framework.di

import android.app.Application
import com.example.cleanarchitecture.framework.RoomNoteDataSource
import com.example.core.reponsitory.NoteReponsitory
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun  provideRepository(app:Application) = NoteReponsitory(RoomNoteDataSource(app))
}