package com.example.modelingrobots.databases.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Regulators
import com.example.modelingrobots.databases.entities.SectionLinks

data class ConfigurationRobotsAndRegulators(
    @Embedded val configurationRobot: ConfigurationsRobots,
    @Relation(
        parentColumn = "robot_id",
        entityColumn = "robot_id"
    )
    val regulators: List<Regulators>
)
