package com.example.cleanarchitecture.framework

import com.example.core.usecase.*

data  class UseCases (
    val addNote: AddNote,
    val getAllNote: GetAllNote,
    val  getNote: GetNote,
    val  removeNote: RemoveNote,
    val getWordCount: GetWordCount

)