package com.example.modelingrobots.databases

import androidx.annotation.WorkerThread
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.Regulators
import com.example.modelingrobots.databases.entities.SectionLinks
import com.example.modelingrobots.databases.entities.Trajectories

class RobotsRepository(private val robotsDao: RobotsDao) {
    /*@Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateRobotConfiguration(configurationsRobots: ConfigurationsRobots) {
        robotsDao.updateRobotConfiguration(configurationsRobots)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateIncisionLink(incisionLink: SectionLinks) {
        robotsDao.updateIncisionLink(incisionLink)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateRegulators(regulators: Regulators) {
        robotsDao.updateRegulators(regulators)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateMotors(motors: Motors) {
        robotsDao.updateMotors(motors)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateTrajectory(trajectories: Trajectories) {
        robotsDao.updateTrajectory(trajectories)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllRobotsConfiguration(order:String): List<ConfigurationsRobots> {
        return robotsDao.getAllRobotsConfiguration(order)
    }*/
}