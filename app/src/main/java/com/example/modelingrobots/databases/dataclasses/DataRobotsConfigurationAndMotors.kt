package com.example.modelingrobots.databases.dataclasses

import androidx.room.ColumnInfo

data class DataRobotsConfigurationAndMotors(
    @ColumnInfo(name = "robot_id")
    val robotId: Int,
    @ColumnInfo(name = "motors_id")
    val motorsId: Int
)
