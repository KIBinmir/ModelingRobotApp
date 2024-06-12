package com.example.modelingrobots.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Motors")
data class Motors(
    //@PrimaryKey(autoGenerate = true)
    //var motors_id: Int,
    //@ColumnInfo(name = "robot_id") var robotId: Int,
    var configuraionName: String,
    @ColumnInfo(name = "j1") var j1: Double,
    @ColumnInfo(name = "l1") var l1: Double,
    @ColumnInfo(name = "r1") var r1: Double,
    @ColumnInfo(name = "km1") var km1: Double,
    @ColumnInfo(name = "ke1") var ke1: Double,
    @ColumnInfo(name = "j2") var j2: Double,
    @ColumnInfo(name = "l2") var l2: Double,
    @ColumnInfo(name = "r2") var r2: Double,
    @ColumnInfo(name = "km2") var km2: Double,
    @ColumnInfo(name = "ke2") var ke2: Double,
)
