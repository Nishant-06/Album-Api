package com.example.albumcreation.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("userId")
    val UserId:String?,
    @SerializedName("id")
    val Id:String?,
    @SerializedName("title")
    val title:String?
)