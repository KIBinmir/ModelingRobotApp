package com.example.modelingrobots.databases.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.Trajectories

data class ConfigurationRobotsAndTrajectory(
    @Embedded val configurationRobot: ConfigurationsRobots,
    @Relation(
        parentColumn = "robot_id",
        entityColumn = "robot_id"
    )
    val trajectories: List<Trajectories>
)
