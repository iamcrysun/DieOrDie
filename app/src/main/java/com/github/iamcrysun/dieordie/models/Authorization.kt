package com.github.iamcrysun.dieordie.models
import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="authorizations")
@Parcelize
data class Authorization (
    @PrimaryKey(autoGenerate=true)
    val login: String,
    val password: String,
): Parcelable