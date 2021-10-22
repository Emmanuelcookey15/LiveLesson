package com.ulesson.domain.usecases


import com.ulesson.domain.repositories.MyLessonRepository
import com.ulesson.domain.repositories.PromotedLessonRepository

class GetPromotedLessons(private val promotedLessonRepository: PromotedLessonRepository) {

  suspend operator fun invoke() = promotedLessonRepository.getPromotedLessons()
}