package com.github.iamcrysun.dieordie.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Sees (
    val id: Int,
    val doctor_id: Int,
    val date: String,
    val info: String,
): Parcelable