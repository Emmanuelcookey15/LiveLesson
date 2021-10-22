package com.ulesson.domain.usecases

import com.ulesson.domain.models.Lesson
import com.ulesson.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface LessonRepository {

    fun getPromotedLesson(): Flow<Resource<List<Lesson>>>


    fun getLiveLesson(): Flow<Resource<List<Lesson>>>


}