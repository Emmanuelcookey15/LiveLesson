package com.ulesson.data.apiservice

import com.ulesson.data.models.LessonResponse
import com.ulesson.data.models.ResponseData
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://mock-live-lessons.herokuapp.com/api/v1/"
    }

    @GET("promoted")
    fun getPromoteLessons(): ResponseData


    @GET("lessons")
    fun getLiveLessons(): ResponseData


    @GET("lessons/me")
    fun getMyLessons(): ResponseData
}