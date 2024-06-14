package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modelingrobots.ItemTimeTable
import com.example.modelingrobots.databases.RobotsDao
import com.example.modelingrobots.databases.entities.ConfigurationsRobots
import com.example.modelingrobots.databases.entities.Trajectories
import kotlinx.coroutines.launch

class TrajectoryParametersViewModel: ViewModel() {
    val typeCoordinates = MutableLiveData<String>("Декартовые") // Для дискретной траектории
    val timeTable = MutableLiveData<List<ItemTimeTable>>(List<ItemTimeTable>(2, {ItemTimeTable(0.0, 0.0, 0.0)}))

    // val typeFigure = MutableLiveData<String>("Окружность") // Для непрерывной траектории
    // val typeTrajectory = MutableLiveData<String>("Позиционное")

    fun setValues(typeCoord: String, timeTab: List<ItemTimeTable>) {
        typeCoordinates.value = typeCoord
        timeTable.value = timeTab
    }
    fun getData(filename: String): Trajectories {
        val lst = timeTable.value!!
        return Trajectories(configuraionName = filename,
            typeCoordinates = typeCoordinates.value!!,
            t0 = lst[0].t,
            p1_t0 = lst[0].q1,
            p2_t0 = lst[0].q2,
            t1 = lst[1].t,
            p1_t1 = lst[1].q1,
            p2_t1 = lst[1].q2)
    }
    fun updateViewModelFromDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            var trajectories = dao.getTrajectory(filename)[0]
            trajectories.apply {setValues(typeCoordinates, listOf(ItemTimeTable(t0, p1_t0, p2_t0), ItemTimeTable(t1, p1_t1, p2_t1)))}
        }
    }
    fun insertViewDataInDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.insertTrajectory(getData(filename))
        }
    }
    fun updateDatabaseFromViewModel(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.updateTrajectory(getData(filename))
        }
    }
    fun setDefaultValue() {
        setValues("Обобщённые", listOf(ItemTimeTable(0.0, 0.0, 0.0), ItemTimeTable(10.0, 1.0, 1.0)) )
    }
}