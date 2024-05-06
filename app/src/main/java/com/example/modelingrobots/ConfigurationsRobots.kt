package com.example.modelingrobots

@Entity(tableName="ConfigurationsRobots")
data class ConfigurationsRobots {
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "type_robot") var robot: String,
    @ColumnInfo(name = "q1_min") var l2: Double
    @ColumnInfo(name = "q1") var l2: Double
    @ColumnInfo(name = "q1_max") var q1: Double,
    @ColumnInfo(name = "q2_min") var l2: Double
    @ColumnInfo(name = "q2") var l2: Double
    @ColumnInfo(name = "q2_max") var q2: Double,
    @ColumnInfo(name = "x0") var x0: Double,
    @ColumnInfo(name = "y0") var y0: Double,
    @ColumnInfo(name = "x1") var x1: Double,
    @ColumnInfo(name = "y1") var y1: Double,
    @ColumnInfo(name = "x2") var x2: Double,
    @ColumnInfo(name = "y2") var y2: Double,
    @ColumnInfo(name = "l1") var l1: Double,
    @ColumnInfo(name = "l2") var l2: Double
}