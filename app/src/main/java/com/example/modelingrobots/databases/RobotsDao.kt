package com.example.modelingrobots.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
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
    fun getAllRobotsConfiguration(order:String): List<ConfigurationsRobots>
    @Query("SELECT * FROM sectionlinks ORDER BY :order")
    fun getAllSectionLinks(order:String): List<SectionLinks>
    @Query("SELECT * FROM regulators ORDER BY :order")
    fun getAllRegulators(order:String): List<Regulators>
    @Query("SELECT * FROM motors ORDER BY :order")
    fun getAllMotors(order:String): List<Motors>
    @Query("SELECT * FROM trajectories ORDER BY :order")
    fun getAllTrajectories(order:String): List<Trajectories>

    @Update
    fun updateRobotConfiguration(vararg configurationsRobots: ConfigurationsRobots)
    @Update
    fun updateIncisionLink(vararg incisionLink: SectionLinks)
    @Update
    fun updateRegulators(vararg regulators: Regulators)
    @Update
    fun updateMotors(vararg motors: Motors)
    @Update
    fun updateTrajectory(vararg trajectories: Trajectories)

    @Insert
    fun insertRobotConfiguration(vararg configurationsRobots: ConfigurationsRobots)
    @Insert
    fun insertIncisionLink(vararg incisionLink: SectionLinks)
    @Insert
    fun insertRegulators(vararg regulators: Regulators)
    @Insert
    fun insertMotors(vararg motors: Motors)
    @Insert
    fun insertTrajectory(vararg trajectories: Trajectories)

    @Query("SELECT configuraionName FROM configurationsrobots ORDER BY configuraionName ASC")
    fun getNamesConfigurationsRobots(): List<String>
    /*@Query("SELECT configuraionName FROM configurationsrobots WHERE configuraionName = :nameConfiguration")
    fun getRobotConfigurationIdByName(nameConfiguration: String): String*/
    @Query("SELECT * FROM configurationsrobots WHERE configuraionName = :filename")
    fun getRobotsConfiguration(filename: String): List<ConfigurationsRobots>
    @Query("SELECT * FROM sectionlinks WHERE configuraionName = :filename")
    fun getSectionLink(filename: String): List<SectionLinks>
    @Query("SELECT * FROM regulators WHERE configuraionName = :filename")
    fun getRegulators(filename: String): List<Regulators>
    @Query("SELECT * FROM motors WHERE configuraionName = :filename")
    fun getMotors(filename: String): List<Motors>
    @Query("SELECT * FROM trajectories WHERE configuraionName = :filename")
    fun getTrajectory(filename: String): List<Trajectories>


    /*@Query("SELECT robot_id FROM configurationsrobots WHERE name_configuration = :nameConfiguration")
    fun getRobotConfigurationIdByName(nameConfiguration: String): Int
    @Query("SELECT * FROM configurationsrobots WHERE robot_id = :robot_id")
    fun getRobotsConfigurationById(robot_id: Int): List<ConfigurationsRobots>
    @Query("SELECT * FROM sectionlinks WHERE robot_id = :robot_id")
    fun getSectionLinkById(robot_id: Int): List<SectionLinks>
    @Query("SELECT * FROM regulators WHERE robot_id = :robot_id")
    fun getRegulatorById(robot_id: Int): List<Regulators>
    @Query("SELECT * FROM motors WHERE robot_id = :robot_id")
    fun getMotorById(robot_id: Int): List<Motors>
    @Query("SELECT * FROM trajectories WHERE robot_id = :robot_id")
    fun getTrajectoryById(robot_id: Int): List<Trajectories>*/

    /*@Transaction
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
    fun getRobotConfigurationAndTrajectories(robotId: Int): List<DataRobotsConfigurationAndTrajectories>*/

}