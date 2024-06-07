package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelingrobots.ItemTimeTable

class TrajectoryParametersViewModel: ViewModel() {
    val typeCoordinates = MutableLiveData<String>("Декартовые") // Для дискретной траектории
    val timeTable = MutableLiveData<List<ItemTimeTable>>(List<ItemTimeTable>(2, {ItemTimeTable(0.0, 0.0, 0.0)}))

    // val typeFigure = MutableLiveData<String>("Окружность") // Для непрерывной траектории
    // val typeTrajectory = MutableLiveData<String>("Позиционное")

    fun setValues(typeTraj: String, timeTab: List<ItemTimeTable>) {
        typeCoordinates.value = typeTraj
        timeTable.value = timeTab
    }
}