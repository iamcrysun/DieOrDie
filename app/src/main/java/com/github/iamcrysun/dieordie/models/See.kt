package com.github.iamcrysun.dieordie.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="sees")
@Parcelize
data class See (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val doctor: Int,
    val date: String,
    val info: String,
): Parcelable