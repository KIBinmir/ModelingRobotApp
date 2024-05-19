package com.example.modelingrobots.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Trajectories")
data class Trajectories(
    @PrimaryKey(autoGenerate = true)
    var trajectory_id: Int,
    @ColumnInfo(name = "robot_id") var robotId: Int,
    @ColumnInfo(name = "type_moving") var typeMoving: String,
    @ColumnInfo(name = "type_coordinates") var typeCoordinates: Boolean, //true - relate, false - absolute
    @ColumnInfo(name = "velocity") var velocity: Double?,
    @ColumnInfo(name = "list_point_moving") var listPointMoving: List<List<Double>>
)