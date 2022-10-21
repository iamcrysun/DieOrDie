package com.github.iamcrysun.dieordie.models

import kotlinx.serialization.Serializable

@Serializable
data class Doctor (
    val id: Int,
    val fullName: String,
    val specialization: String,
    val info: String,
)