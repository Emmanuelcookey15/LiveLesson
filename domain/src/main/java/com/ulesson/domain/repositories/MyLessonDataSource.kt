package com.ulesson.domain.repositories

import com.ulesson.domain.models.Lesson

interface MyLessonDataSource<T> {

    suspend fun read(): List<T>?

    suspend fun add()

}