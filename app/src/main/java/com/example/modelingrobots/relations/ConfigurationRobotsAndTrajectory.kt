package com.example.modelingrobots.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.modelingrobots.entities.ConfigurationsRobots
import com.example.modelingrobots.entities.Motors
import com.example.modelingrobots.entities.Trajectories

data class ConfigurationRobotsAndTrajectory(
    @Embedded val configurationRobot: ConfigurationsRobots,
    @Relation(
        parentColumn = "robot_id",
        entityColumn = "robot_id"
    )
    val trajectories: List<Trajectories>
)
