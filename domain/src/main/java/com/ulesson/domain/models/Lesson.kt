package com.ulesson.domain.models

open class Lesson(
    open val id: Int? = null,
    open val tutor: String? = null,
    open val subject:String ?=null,
    open val image_url: String? =null,
    open val status: String? = null,
    open val topic:String ?=null,
    open val createdAt: String? = null,
    open val start_at: String? =null,
    open val expires_at: String? =null
)