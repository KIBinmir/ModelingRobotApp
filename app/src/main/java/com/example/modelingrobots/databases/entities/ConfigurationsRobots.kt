package com.example.modelingrobots.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="ConfigurationsRobots")
data class ConfigurationsRobots(
    @PrimaryKey(autoGenerate = true)
    var robot_id: Int,
    @ColumnInfo(name = "name_configuration") var nameConfiguration: String,
    @ColumnInfo(name = "user_id") var userId: Int,
    @ColumnInfo(name = "type_robot") var robot: String,
    @ColumnInfo(name = "l1") var l1: Double,
    @ColumnInfo(name = "l2") var l2: Double,
    @ColumnInfo(name = "q1_min") var q1Min: Double,
    @ColumnInfo(name = "q1_max") var q1Max: Double,
    @ColumnInfo(name = "q2_min") var q2Min: Double,
    @ColumnInfo(name = "q2_max") var q2Max: Double,
)
