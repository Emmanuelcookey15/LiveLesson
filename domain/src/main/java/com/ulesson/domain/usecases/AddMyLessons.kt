package com.ulesson.domain.usecases


import com.ulesson.domain.repositories.MyLessonRepository

class AddMyLessons(private val myLessonRepository: MyLessonRepository) {

  suspend operator fun invoke() = myLessonRepository.addMyLessons()
}