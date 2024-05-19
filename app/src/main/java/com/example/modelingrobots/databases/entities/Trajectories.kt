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
    @ColumnInfo(name = "point0") var point0: String,
    @ColumnInfo(name = "point1") var point1: String,
    @ColumnInfo(name = "point2") var point2: String,
    @ColumnInfo(name = "point3") var point3: String,
    @ColumnInfo(name = "point4") var point4: String,
    @ColumnInfo(name = "point5") var point5: String,
    @ColumnInfo(name = "point6") var point6: String,
    @ColumnInfo(name = "point7") var point7: String,
    @ColumnInfo(name = "point8") var point8: String
)