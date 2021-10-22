package com.ulesson.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ResponseData(

    @SerializedName("success")
    @Expose
    var success: Boolean? = null,

    @SerializedName("data")
    @Expose
    var data: List<LessonResponse>?=null,

)

data class LessonResponse(

    @SerializedName("id")
    @Expose
    var id: String? = null,

    @SerializedName("tutor")
    @Expose
    var tutor: Tutor? = null,

    @SerializedName("subject")
    @Expose
    var subject: Subject?=null,

    @SerializedName("image_url")
    @Expose
    var image_url: String? =null,

    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("topic")
    @Expose
    var topic:String ?=null,

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null,

    @SerializedName("start_at")
    @Expose
    var start_at: String? =null,

    @SerializedName("expires_at")
    @Expose
    var expires_at: String? =null
)


data class Subject(

    @SerializedName("name")
    @Expose
    var name: String? =null
)


data class Tutor(

    @SerializedName("firstname")
    @Expose
    var firstname: String? =null,

    @SerializedName("lastname")
    @Expose
    var lastname: String? =null
)