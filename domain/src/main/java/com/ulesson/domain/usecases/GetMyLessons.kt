package com.ulesson.domain.usecases


import com.ulesson.domain.repositories.MyLessonRepository

class GetMyLessons<T>(private val myLessonRepository: MyLessonRepository<T>) {

  suspend operator fun invoke() = myLessonRepository.getMyLessons()
}