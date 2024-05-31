package com.example.modelingrobots.databases.dataclasses

import androidx.room.ColumnInfo

data class DataUsersAndConfigurationsRobots(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "robot_id")
    val robotId: Int,
)
