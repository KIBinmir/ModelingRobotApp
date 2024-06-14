package com.example.modelingrobots.databases

import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.Regulators
import com.example.modelingrobots.databases.entities.SectionLinks
import com.example.modelingrobots.databases.entities.Trajectories

class DefaultData {
    companion object {
        val configurationsRobotses = listOf(ConfigurationsRobots("my_robots", 0, "Декарт", 1.0, 1.0, 0.0, 1.0, 0.0, 1.0))
        val sectionLinkses = listOf(SectionLinks("my_robots", "Круглое сплошное", "Аллюминий", 0.1, 0.0, 0.0))
        val motorses = listOf(Motors("my_robots", 0.03, 0.04, 4.0, 1.0, 1.0, 0.03, 0.04, 4.0, 1.0, 1.0))
        val regulatorses = listOf(Regulators("my_robots", 1.0, 0.0, 0.0, 1.0, 0.0, 0.0))
        val trajectorieses = listOf(Trajectories("my_robots", "Обобщённые", 0.0, 0.0, 0.0, 10.0, 0.0, 0.0))
    }
}