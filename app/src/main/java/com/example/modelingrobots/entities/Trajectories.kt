package com.example.modelingrobots.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Trajectories")
data class Trajectories(
    @PrimaryKey(autoGenerate = true)
    var trajectory_id: Int,
    @ColumnInfo(name = "robot_id") var robotId: Int
)