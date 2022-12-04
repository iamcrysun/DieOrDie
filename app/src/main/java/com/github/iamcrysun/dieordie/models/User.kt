package com.github.iamcrysun.dieordie.models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="users")
data class User (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val email: String,
    val password: String,
)