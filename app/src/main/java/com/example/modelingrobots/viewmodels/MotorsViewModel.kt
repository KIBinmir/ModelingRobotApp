package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modelingrobots.databases.RobotsDao
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.Regulators
import com.example.modelingrobots.robots.otherParts.Motor2Simple
import com.example.modelingrobots.robots.otherParts.PID
import kotlinx.coroutines.launch

class MotorsViewModel : ViewModel() {
    val r1 = MutableLiveData<Double>(4.0)
    val r2 = MutableLiveData<Double>(4.0)
    val ke1 = MutableLiveData<Double>(1.0)
    val ke2 = MutableLiveData<Double>(1.0)
    val km1 = MutableLiveData<Double>(1.0)
    val km2 = MutableLiveData<Double>(1.0)
    val j1 = MutableLiveData<Double>(0.3)
    val j2 = MutableLiveData<Double>(0.3)
    val l1 = MutableLiveData<Double>(0.04)
    val l2 = MutableLiveData<Double>(0.04)

    var motor1: Motor2Simple = Motor2Simple(j1.value!!, l1.value!!, r1.value!!, km1.value!!, ke1.value!!)
    var motor2: Motor2Simple = Motor2Simple(j2.value!!, l2.value!!, r2.value!!, km2.value!!, ke2.value!!)

    fun setValues1(j11: Double, l11: Double, r11: Double, km11: Double, ke11: Double) {
        j1.value = j11
        l1.value = l11
        r1.value = r11
        km1.value = km11
        ke1.value = ke11
        motor1 = Motor2Simple(j11, l11, r11, km11, ke11)
    }

    fun setValues2(j22: Double, l22: Double, r22: Double, km22: Double, ke22: Double) {
        j2.value = j22
        l2.value = l22
        r2.value = r22
        km2.value = km22
        ke2.value = ke22
        motor2 = Motor2Simple(j22, l22, r22, km22, ke22)
    }
    fun getData(fileName: String): Motors {
        return Motors(configuraionName = fileName,
            j1 = j1.value!!,
            j2 = j2.value!!,
            l1 = l1.value!!,
            l2 = l2.value!!,
            r1 = r1.value!!,
            r2 = r2.value!!,
            km1 = km1.value!!,
            km2 = km2.value!!,
            ke1 = ke1.value!!,
            ke2 = ke2.value!!)
    }
    fun updateViewModelFromDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            var motors = dao.getMotors(filename)[0]
            motors.apply {
                setValues1(j1, l1, r1, km1, ke1)
                setValues2(j2, l2, r2, km2, ke2)
            }
        }
    }
    fun insertViewDataInDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.insertMotors(getData(filename))
        }
    }
    fun updateDatabaseFromViewModel(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.updateMotors(getData(filename))
        }
    }
    fun setDefaultValue() {
        setValues1(0.3, 0.04, 4.0, 1.0, 1.0)
        setValues2(0.3, 0.04, 4.0, 1.0, 1.0)
    }
}