package com.example.cleanarchitecture.framework

import android.content.Context
import com.example.cleanarchitecture.framework.database.DatabaseService
import com.example.cleanarchitecture.framework.database.NoteEntity
import com.example.core.data.Note
import com.example.core.reponsitory.NoteDataSource

class RoomNoteDataSource(context: Context):NoteDataSource {
    val noteDao = DatabaseService.getIntance(context).noteDao()
    override suspend fun add(note: Note)= noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? = noteDao.getNoteEntity(id)?.toNote()
    override suspend fun getAll(): List<Note> = noteDao.getAllNotesEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}