package com.example.core.usecase

import com.example.core.data.Note
import com.example.core.reponsitory.NoteReponsitory

class AddNote(private  val  noteReponsitory: NoteReponsitory) {
    suspend operator  fun invoke(note:Note)= noteReponsitory.addNote(note)
}