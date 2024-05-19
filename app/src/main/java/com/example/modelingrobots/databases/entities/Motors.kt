package com.example.modelingrobots.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Motors")
data class Motors(
    @PrimaryKey(autoGenerate = true)
    var motors_id: Int,
    @ColumnInfo(name = "robot_id") var robotId: Int,
    @ColumnInfo(name = "j1") var j1: Double,
    @ColumnInfo(name = "n1") var n1: Double,
    @ColumnInfo(name = "u_max1") var uMax1: Double,
    @ColumnInfo(name = "ku1") var ku1: Double,
    @ColumnInfo(name = "ke1") var ke1: Double,
    @ColumnInfo(name = "j2") var j2: Double,
    @ColumnInfo(name = "n2") var n2: Double,
    @ColumnInfo(name = "u_max2") var uMax2: Double,
    @ColumnInfo(name = "ku2") var ku2: Double,
    @ColumnInfo(name = "ke2") var ke2: Double,
)
