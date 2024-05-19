package com.example.modelingrobots.databases.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.User


data class UsersAndConfigurationRobots(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_id"
    )
    val listConfigurationRobots: List<ConfigurationsRobots>
)
