package com.example.modelingrobots.databases.dataclasses

import androidx.room.ColumnInfo

data class DataRobotsConfigurationAndTrajectories(
    @ColumnInfo(name = "robot_id")
    val robotId: Int,
    @ColumnInfo(name = "trajectory_id")
    val trajectoryId: Int
)
