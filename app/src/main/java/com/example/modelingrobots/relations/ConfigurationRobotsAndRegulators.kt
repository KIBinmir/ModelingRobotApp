package com.example.modelingrobots.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.modelingrobots.entities.ConfigurationsRobots
import com.example.modelingrobots.entities.Regulators
import com.example.modelingrobots.entities.SectionLinks

data class ConfigurationRobotsAndRegulators(
    @Embedded val configurationRobot: ConfigurationsRobots,
    @Relation(
        parentColumn = "robot_id",
        entityColumn = "robot_id"
    )
    val regulators: List<Regulators>
)
