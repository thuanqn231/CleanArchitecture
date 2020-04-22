package com.example.cleanarchitecture.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [NoteEntity::class],version = 1)
abstract class DatabaseService: RoomDatabase() {
    companion object{
        private  const val  DATABASE_NAME = "note.db"
        private  var instance: DatabaseService?=null
        private  fun  create(context: Context):DatabaseService =
            Room.databaseBuilder(context,DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        fun  getIntance(context: Context):DatabaseService =
            (instance?: create(context)).also { instance = it }
    }
    abstract  fun  noteDao():NoteDao
}