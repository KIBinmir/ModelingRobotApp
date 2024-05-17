package com.example.modelingrobots.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var user_id: Int,
    @ColumnInfo(name = "login") var login: String,
    @ColumnInfo(name = "password") var password: String,
)
