package com.example.modelingrobots.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
    version = 1,
    exportSchema = true
)
abstract class RobotsDatabase: RoomDatabase() {
    abstract val robotsDao: RobotsDao
    /*companion object {
        @Volatile
        private var Instance: RobotsDatabase? = null
        fun getDatabase(context: Context): RobotsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, RobotsDatabase::class.java, "robotsdb.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }*/
}