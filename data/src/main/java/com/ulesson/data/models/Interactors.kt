package com.ulesson.data.models


import com.ulesson.domain.usecases.AddMyLessons
import com.ulesson.domain.usecases.GetLiveLessons
import com.ulesson.domain.usecases.GetMyLessons
import com.ulesson.domain.usecases.GetPromotedLessons

data class Interactors(
    val addMyLessons: AddMyLessons,
    val getMyLessons: GetMyLessons,
    val getLiveLessons: GetLiveLessons,
    val getPromotedLessons: GetPromotedLessons
)
