package com.example.modelingrobots.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SectionLinks")
data class SectionLinks(
    //@PrimaryKey(autoGenerate = true)
    //var sectionLink_id: Int,
    //@ColumnInfo(name = "robot_id") var robotId: Int,
    @PrimaryKey
    var configuraionName: String,
    @ColumnInfo(name = "type_section") var typeSection: String,
    @ColumnInfo(name = "material") var material: String,
    @ColumnInfo(name = "first_param") var param1: Double,
    @ColumnInfo(name = "second_param") var param2: Double?,
    @ColumnInfo(name = "third_param") var param3: Double?
)
