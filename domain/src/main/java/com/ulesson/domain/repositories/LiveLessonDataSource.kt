package com.ulesson.domain.repositories

import com.ulesson.domain.models.Lesson

interface LiveLessonDataSource {


    suspend fun readLiveLesson(): List<Lesson>


}