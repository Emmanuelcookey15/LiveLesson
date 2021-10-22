package com.ulesson.data.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ulesson.domain.models.Lesson
import kotlinx.parcelize.Parcelize

@Entity(tableName = "my_lessons")
@Parcelize
data class LessonEntity(
    @PrimaryKey
    override val id: Int? = null,
    override val tutor: String? = null,
    override val subject:String ?=null,
    override val image_url: String? =null,
    override val status: String? = null,
    override val topic:String ?=null,
    override val createdAt: String? = null,
    override val start_at: String? =null,
    override val expires_at: String? =null):
    Lesson(id, tutor, subject, image_url, status, topic, createdAt, start_at, expires_at),
    Parcelable
