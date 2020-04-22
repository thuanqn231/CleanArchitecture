package com.example.cleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.framework.di.ApplicationModule
import com.example.cleanarchitecture.framework.di.DaggerViewModelComponent
import com.example.core.data.Note
import com.example.core.reponsitory.NoteReponsitory
import com.example.core.usecase.AddNote
import com.example.core.usecase.GetAllNote
import com.example.core.usecase.GetNote
import com.example.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

//    private val reponsitory = NoteReponsitory(RoomNoteDataSource(application))
    //    val useCases = UseCases(
//        AddNote(reponsitory),
//        GetAllNote(reponsitory),
//        GetNote(reponsitory),
//        RemoveNote(reponsitory)
//    )
// change thanh
    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    //end change
    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNote()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }
            notes.postValue(noteList)
        }
    }

}