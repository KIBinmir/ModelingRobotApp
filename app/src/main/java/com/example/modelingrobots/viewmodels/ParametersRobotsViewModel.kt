package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modelingrobots.ItemTimeTable
import com.example.modelingrobots.databases.RobotsDao
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.SectionLinks
import com.example.modelingrobots.robots.dynamics.DynamicRobot
import com.example.modelingrobots.robots.kinematics.Robot
import com.example.modelingrobots.robots.kinematics.RobotCylindr
import com.example.modelingrobots.robots.kinematics.RobotDekart
import com.example.modelingrobots.robots.kinematics.RobotKoler
import com.example.modelingrobots.robots.kinematics.RobotSkara
import com.example.modelingrobots.robots.linksSections.Materials
import kotlinx.coroutines.launch

class ParametersRobotsViewModel: ViewModel() {
    val typeRobot = MutableLiveData<String>("Декарт")
    val l1 = MutableLiveData<Double>(1.0)
    val l2 = MutableLiveData<Double>(0.5)
    val q1min = MutableLiveData<Double>(0.0)
    val q1max = MutableLiveData<Double>(1.0)
    val q2min = MutableLiveData<Double>(0.0)
    val q2max = MutableLiveData<Double>(0.5)
    lateinit var robotConfig: Robot

    fun setValues(typeR: String, l11: Double, l22: Double, q1min1: Double, q1max1: Double, q2min2: Double, q2max2: Double) {
        l1.value = l11
        l2.value = l22
        q1min.value = q1min1
        q1max.value = q1max1
        q2min.value = q2min2
        q2max.value = q2max2
        typeRobot.value = typeR
        when (typeR) {
            "Декарт" -> robotConfig = RobotDekart(l11, l22, q1min1, q1max1, q2min2, q2max2)
            "Цилиндр" -> robotConfig = RobotCylindr(l11, l22, q1min1, q1max1, q2min2, q2max2)
            "Колер" -> robotConfig = RobotKoler(l11, l22, q1min1, q1max1, q2min2, q2max2)
            "Скара" -> robotConfig = RobotSkara(l11, l22, q1min1, q1max1, q2min2, q2max2)
        }
    }
    fun getData(fileName: String): ConfigurationsRobots {
        return ConfigurationsRobots(configuraionName = fileName,
            robot = typeRobot.value!!,
            userId = 0,
            l1 = l1.value!!,
            l2 = l2.value!!,
            q1Max = q1max.value!!,
            q1Min = q1min.value!!,
            q2Min = q2min.value!!,
            q2Max = q2max.value!!)
    }
    fun updateViewModelFromDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            var configurationsRobots = dao.getRobotsConfiguration(filename)[0]
            configurationsRobots.apply {setValues(robot, l1, l2, q1Min, q1Max, q2Min,q2Max)}
        }
    }
    fun insertViewDataInDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.insertRobotConfiguration(getData(filename))
        }
    }
    fun updateDatabaseFromViewModel(dao: RobotsDao, filename: String) {
        val configurationsRobots = getData(filename)
        viewModelScope.launch {
            dao.updateRobotConfiguration(configurationsRobots)
        }
    }
    fun setDefaultValue() {
        setValues("Декарт", 1.0, 1.0, 0.0, 1.0, 0.0, 1.0 )
    }
}