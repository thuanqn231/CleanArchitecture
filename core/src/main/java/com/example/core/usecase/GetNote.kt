package com.example.core.usecase

import com.example.core.reponsitory.NoteReponsitory

class GetNote(private  val reponsitory: NoteReponsitory) {
    suspend operator fun  invoke(id:Long) = reponsitory.getNote(id)
}