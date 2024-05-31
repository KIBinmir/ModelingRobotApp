package com.example.modelingrobots.databases

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.modelingrobots.databases.dataclasses.DataRobotsConfigurationAndMotors
import com.example.modelingrobots.databases.dataclasses.DataRobotsConfigurationAndRegulators
import com.example.modelingrobots.databases.dataclasses.DataRobotsConfigurationAndSectionLinks
import com.example.modelingrobots.databases.dataclasses.DataRobotsConfigurationAndTrajectories
import com.example.modelingrobots.databases.dataclasses.DataUsersAndConfigurationsRobots
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
    @Query("SELECT user_id, robot_id FROM configurationsrobots")
    fun getUsersAndRobotsConfiguration(): List<DataUsersAndConfigurationsRobots>
    @Transaction
    @Query("SELECT user_id, robot_id FROM configurationsrobots WHERE user_id = :userId")
    fun getUserAndRobotsConfiguration(userId: Int): List<DataUsersAndConfigurationsRobots>
    @Transaction
    @Query("SELECT robot_id, sectionLink_id FROM sectionlinks WHERE robot_id = :robotId")
    fun getRobotConfigurationAndSectionLinks(robotId: Int): List<DataRobotsConfigurationAndSectionLinks>

    @Transaction
    @Query("SELECT robot_id, motors_id FROM motors WHERE robot_id = :robotId")
    fun getRobotConfigurationAndMotors(robotId: Int): List<DataRobotsConfigurationAndMotors>

    @Transaction
    @Query("SELECT robot_id, regulators_id FROM regulators WHERE robot_id = :robotId")
    fun getRobotConfigurationAndRegulators(robotId: Int): List<DataRobotsConfigurationAndRegulators>

    @Transaction
    @Query("SELECT robot_id, trajectory_id FROM trajectories WHERE robot_id = :robotId")
    fun getRobotConfigurationAndTrajectories(robotId: Int): List<DataRobotsConfigurationAndTrajectories>

}