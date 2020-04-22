package com.example.core.usecase

import com.example.core.data.Note
import com.example.core.reponsitory.NoteReponsitory

class RemoveNote(private  val noteReponsitory: NoteReponsitory) {
    suspend operator  fun invoke(note: Note)= noteReponsitory.removeNote(note)
}