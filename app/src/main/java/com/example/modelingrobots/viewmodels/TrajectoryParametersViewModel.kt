package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelingrobots.ItemTimeTable
import com.example.modelingrobots.databases.entities.Trajectories

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
}