package com.ulesson.domain.usecases


import com.ulesson.domain.repositories.LiveLessonRepository
import com.ulesson.domain.repositories.MyLessonRepository

class GetLiveLessons(private val liveLessonRepository: LiveLessonRepository) {

  suspend operator fun invoke() = liveLessonRepository.getLiveLessons()
}