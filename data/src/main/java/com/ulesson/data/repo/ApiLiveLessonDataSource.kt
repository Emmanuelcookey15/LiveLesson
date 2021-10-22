package com.ulesson.data.repo

import com.ulesson.data.apiservice.ApiService
import com.ulesson.data.db.AppDatabase
import com.ulesson.data.mappers.LessonMapper
import com.ulesson.domain.models.Lesson
import com.ulesson.domain.repositories.LiveLessonDataSource
import javax.inject.Inject

class ApiLiveLessonDataSource @Inject constructor(private val lessonMapper: LessonMapper,
                                                 private val api: ApiService
) : LiveLessonDataSource {
    override suspend fun readLiveLesson(): List<Lesson> {
       return lessonMapper.toLesson(
            api.getLiveLessons()
        )
    }
}