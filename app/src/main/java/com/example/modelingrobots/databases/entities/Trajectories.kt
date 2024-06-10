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
    @ColumnInfo(name = "type_coordinates") var typeCoordinates: String,
    @ColumnInfo(name = "velocity") var velocity: Double?,
    @ColumnInfo(name = "t0") var t0: Double,
    @ColumnInfo(name = "p1(t0)") var p1_t0: Double,
    @ColumnInfo(name = "p2(t0)") var p2_t0: Double,
    @ColumnInfo(name = "t1") var t1: Double,
    @ColumnInfo(name = "p1(t1)") var p1_t1: Double,
    @ColumnInfo(name = "p2(t1)") var p2_t1: Double,
)