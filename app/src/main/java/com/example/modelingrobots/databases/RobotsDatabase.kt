package com.example.modelingrobots.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.Regulators
import com.example.modelingrobots.databases.entities.SectionLinks
import com.example.modelingrobots.databases.entities.Trajectories

@Database(
    entities = [
        ConfigurationsRobots::class,
        SectionLinks::class,
        Motors::class,
        Regulators::class,
        Trajectories::class
    ],
    version = 1
)
abstract class RobotsDatabase: RoomDatabase() {
    abstract val robotsDao: RobotsDao
}