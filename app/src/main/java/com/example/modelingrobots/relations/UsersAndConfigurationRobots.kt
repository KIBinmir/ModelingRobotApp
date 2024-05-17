package com.example.modelingrobots.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.modelingrobots.entities.ConfigurationsRobots
import com.example.modelingrobots.entities.User


data class UsersAndConfigurationRobots(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_id"
    )
    val listConfigurationRobots: List<ConfigurationsRobots>
)
