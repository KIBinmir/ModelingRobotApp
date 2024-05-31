package com.example.modelingrobots.databases.dataclasses

import androidx.room.ColumnInfo

data class DataRobotsConfigurationAndRegulators(
    @ColumnInfo(name = "robot_id")
    val robotId: Int,
    @ColumnInfo(name = "regulators_id")
    val regulatorsId: Int
)
