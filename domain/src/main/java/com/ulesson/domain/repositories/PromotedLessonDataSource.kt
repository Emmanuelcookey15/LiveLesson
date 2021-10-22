package com.ulesson.domain.repositories

import com.ulesson.domain.models.Lesson

interface PromotedLessonDataSource {


    suspend fun readPromotedLesson(): List<Lesson>


}