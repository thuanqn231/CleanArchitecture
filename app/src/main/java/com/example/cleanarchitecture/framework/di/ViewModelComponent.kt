package com.example.cleanarchitecture.framework.di

import com.example.cleanarchitecture.framework.ListViewModel
import com.example.cleanarchitecture.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class,RepositoryModule::class,UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}