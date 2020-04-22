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

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private  val coroutineScope = CoroutineScope(Dispatchers.IO)

//    private val reponsitory = NoteReponsitory(RoomNoteDataSource(application))
//    val useCases = UseCases(
//        AddNote(reponsitory),
//        GetAllNote(reponsitory),
//        GetNote(reponsitory),
//        RemoveNote(reponsitory)
//    )
// change thanh
    @Inject
    lateinit var  useCases:UseCases
    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    //end change
    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()
    fun  saveNote(note: Note){
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }
    fun getNote(id: Long){
        coroutineScope.launch {
            val note = useCases.getNote(id)
            currentNote.postValue(note)
        }
    }
    fun  deleteNote(note: Note){
        coroutineScope.launch {
            useCases.removeNote(note)
            saved.postValue(true)
        }
    }
}