package com.ulesson.data.repo

import com.ulesson.data.models.Interactors
import com.ulesson.domain.repositories.*
import com.ulesson.domain.usecases.AddMyLessons
import com.ulesson.domain.usecases.GetLiveLessons
import com.ulesson.domain.usecases.GetMyLessons
import com.ulesson.domain.usecases.GetPromotedLessons
import javax.inject.Inject

class Repository @Inject constructor(
    private val roomMyLessonDataSource: RoomMyLessonDataSource,
    private val apiLiveLessonDataSource: ApiLiveLessonDataSource,
    private val apiPromotedLessonDataSource: ApiPromotedLessonDataSource
){

    private val myLessonRepository = MyLessonRepository(roomMyLessonDataSource)
    private val liveLessonRepository = LiveLessonRepository(apiLiveLessonDataSource)
    private val promotedLessonRepository = PromotedLessonRepository(apiPromotedLessonDataSource)


    fun getLessonsData(): Interactors {


        return Interactors(
            AddMyLessons(myLessonRepository),
            GetMyLessons(myLessonRepository),
            GetLiveLessons(liveLessonRepository),
            GetPromotedLessons(promotedLessonRepository)
        )

    }



}