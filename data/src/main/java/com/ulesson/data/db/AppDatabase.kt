package com.ulesson.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LessonEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun myLessonDao(): MyLessonDao

}