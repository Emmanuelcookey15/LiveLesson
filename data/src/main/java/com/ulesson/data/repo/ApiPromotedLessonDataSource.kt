package com.ulesson.data.repo

import com.ulesson.data.apiservice.ApiService
import com.ulesson.data.mappers.LessonMapper
import com.ulesson.domain.models.Lesson
import com.ulesson.domain.repositories.PromotedLessonDataSource
import javax.inject.Inject

class ApiPromotedLessonDataSource @Inject constructor(private val lessonMapper: LessonMapper,
                                                      private val api: ApiService
) : PromotedLessonDataSource {

    override suspend fun readPromotedLesson(): List<Lesson> {
        return lessonMapper.toLesson(
            api.getPromoteLessons()
        )
    }
}