package com.ulesson.data.repo

import com.ulesson.data.apiservice.ApiService
import com.ulesson.data.db.AppDatabase
import com.ulesson.data.db.LessonEntity
import com.ulesson.data.mappers.LessonMapper
import com.ulesson.domain.repositories.MyLessonDataSource
import javax.inject.Inject

class RoomMyLessonDataSource @Inject constructor(private val lessonMapper: LessonMapper,
                                                private val api: ApiService,
                                                private val db: AppDatabase
) : MyLessonDataSource<LessonEntity> {

    private val myLessonDao = db.myLessonDao()


    override suspend fun read(): List<LessonEntity>? {
        return myLessonDao.getAll().value
    }


    override suspend fun add() {
        myLessonDao.insertLesson(
            lessonMapper.toLessonEntity(
                api.getMyLessons()
            )
        )
    }
}