package com.example.core.usecase

import com.example.core.reponsitory.NoteReponsitory

class GetAllNote(private  val reponsitory: NoteReponsitory) {
    suspend operator  fun invoke()  =reponsitory.getAllNote()
}