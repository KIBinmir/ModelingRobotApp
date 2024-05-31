package com.example.modelingrobots.databases.dataclasses

import androidx.room.ColumnInfo

data class DataRobotsConfigurationAndSectionLinks(
    @ColumnInfo(name = "robot_id")
    val robotId: Int,
    @ColumnInfo(name = "sectionLink_id")
    val sectionLink_id: Int,
)
