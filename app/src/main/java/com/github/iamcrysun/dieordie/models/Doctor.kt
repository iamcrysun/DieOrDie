package com.github.iamcrysun.dieordie.models

import com.google.gson.annotations.SerializedName

data class Doctor (
    @SerializedName("id") val id: Int,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("specialization") val specialization: String,
    @SerializedName("info") val info: String,
)