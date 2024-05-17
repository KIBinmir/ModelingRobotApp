package com.example.modelingrobots.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Regulators")
data class Regulators(
    @PrimaryKey(autoGenerate = true)
    var regulators_id: Int,
    @ColumnInfo(name = "robot_id") var robotId: Int,
    @ColumnInfo(name = "kp1") var kp1: Double,
    @ColumnInfo(name = "ki1") var ki1: Double,
    @ColumnInfo(name = "kd1") var kd1: Double,
    @ColumnInfo(name = "kp2") var kp2: Double,
    @ColumnInfo(name = "ki2") var ki2: Double,
    @ColumnInfo(name = "kd2") var kd2: Double,
)
