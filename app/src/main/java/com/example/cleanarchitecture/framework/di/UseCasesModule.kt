package com.example.cleanarchitecture.framework.di

import com.example.cleanarchitecture.framework.UseCases
import com.example.core.reponsitory.NoteReponsitory
import com.example.core.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun  getUseCases(reponsitory: NoteReponsitory)= UseCases(
        AddNote(reponsitory),
        GetAllNote(reponsitory),
        GetNote(reponsitory),
        RemoveNote(reponsitory),
        GetWordCount()
    )
}