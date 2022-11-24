package com.github.iamcrysun.dieordie.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="doctors")
@Parcelize
data class Doctor (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val fullName: String,
    val specialization: String,
    val info: String,
): Parcelable