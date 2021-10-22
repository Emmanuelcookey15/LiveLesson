package com.ulesson.domain.repositories


class PromotedLessonRepository(private val dataSource: PromotedLessonDataSource) {

  suspend fun getPromotedLessons() = dataSource.readPromotedLesson()

}