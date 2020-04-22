package com.example.cleanarchitecture.framework.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert(onConflict = REPLACE)
    suspend fun  addNoteEntity(noteEntity: NoteEntity)

    @Query("select * from note where id =:id")
    suspend fun  getNoteEntity(id:Long): NoteEntity?

    @Query("select * from note")
    suspend fun  getAllNotesEntities(): List<NoteEntity>

    @Delete
    suspend fun deleteNoteEntity(noteEntity: NoteEntity)
}