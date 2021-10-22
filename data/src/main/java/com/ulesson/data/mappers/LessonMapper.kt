package com.ulesson.data.mappers

import com.ulesson.data.db.LessonEntity
import com.ulesson.data.models.ResponseData
import com.ulesson.domain.models.Lesson
import javax.inject.Inject

class LessonMapper @Inject constructor() {


    fun toLesson(responseData: ResponseData): List<Lesson> {
        return responseData.data!!.map {
            Lesson(
                it.id?.toInt(),
                "${it.tutor?.firstname} ${it.tutor?.lastname}",
                it.subject?.name,
                it.image_url,
                it.status,
                it.topic,
                it.createdAt,
                it.start_at,
                it.expires_at
            )
        }
    }


    fun toLessonEntity(responseData: ResponseData): List<LessonEntity> {
        return responseData.data!!.map {
            LessonEntity(
                it.id?.toInt(),
                "${it.tutor?.firstname} ${it.tutor?.lastname}",
                it.subject?.name,
                it.image_url,
                it.status,
                it.topic,
                it.createdAt,
                it.start_at,
                it.expires_at
            )
        }
    }


}