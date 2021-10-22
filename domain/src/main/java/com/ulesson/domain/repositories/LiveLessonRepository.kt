package com.ulesson.domain.repositories

class LiveLessonRepository(private val dataSource: LiveLessonDataSource) {

  suspend fun getLiveLessons() = dataSource.readLiveLesson()

}