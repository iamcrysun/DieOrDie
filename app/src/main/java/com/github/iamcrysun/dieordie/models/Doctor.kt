package com.github.iamcrysun.dieordie.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doctor (
    val id: Int,
    val fullName: String,
    val specialization: String,
    val info: String,
): Parcelable