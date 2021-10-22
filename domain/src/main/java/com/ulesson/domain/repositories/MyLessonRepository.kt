package com.ulesson.domain.repositories


class MyLessonRepository<T>(private val dataSource: MyLessonDataSource<T>) {


  suspend fun getMyLessons() = dataSource.read()

  suspend fun addMyLessons() = dataSource.add()

}