package com.example.modelingrobots.databases

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.Regulators
import com.example.modelingrobots.databases.entities.SectionLinks
import com.example.modelingrobots.databases.entities.Trajectories
import com.example.modelingrobots.databases.relations.ConfigurationRobotsAndMotors
import com.example.modelingrobots.databases.relations.ConfigurationRobotsAndRegulators
import com.example.modelingrobots.databases.relations.ConfigurationRobotsAndSectionLinks
import com.example.modelingrobots.databases.relations.ConfigurationRobotsAndTrajectory
import com.example.modelingrobots.databases.relations.UsersAndConfigurationRobots

@Dao
interface RobotsDao {
    @Query("SELECT * FROM configurationsrobots ORDER BY :order")
    fun getRobotsConfiguration(order:String): List<ConfigurationsRobots>
    @Query("SELECT * FROM sectionlinks ORDER BY :order")
    fun getSectionLinks(order:String): List<SectionLinks>
    @Query("SELECT * FROM regulators ORDER BY :order")
    fun getRegulators(order:String): List<Regulators>
    @Query("SELECT * FROM motors ORDER BY :order")
    fun getMotors(order:String): List<Motors>
    @Query("SELECT * FROM trajectories ORDER BY :order")
    fun getTrajectories(order:String): List<Trajectories>
    @Transaction
    @Query("SELECT * FROM configurationsrobots WHERE robot_id = :robotId")
    fun getUsersAndRobotsConfiguration(robotId: Int): List<UsersAndConfigurationRobots>
    @Transaction
    @Query("SELECT * FROM sectionlinks WHERE robot_id = :robotId")
    fun getRobotsConfigurationAndSectionLinks(robotId: Int): List<ConfigurationRobotsAndSectionLinks>

    @Transaction
    @Query("SELECT * FROM motors WHERE robot_id = :robotId")
    fun getRobotsConfigurationAndMotors(robotId: Int): List<ConfigurationRobotsAndMotors>

    @Transaction
    @Query("SELECT * FROM regulators WHERE robot_id = :robotId")
    fun getRobotsConfigurationAndRegulators(robotId: Int): List<ConfigurationRobotsAndRegulators>

    @Transaction
    @Query("SELECT * FROM trajectories WHERE robot_id = :robotId")
    fun getRobotsConfigurationAndTrajectories(robotId: Int): List<ConfigurationRobotsAndTrajectory>

}