package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrajectoryParametersModelView: ViewModel() {
    val typeTrajectory = MutableLiveData<String>("Позиционное")
    val typeCoordinates = MutableLiveData<String>("Обобщённые") // Для дискретной траектории
    val typeFigure = MutableLiveData<String>("Окружность") // Для непрерывной траектории
    val timeTable = MutableLiveData<String>("Обобщённые")
    val lineparam = MutableLiveData<String>("Обобщённые")
    val circleParam = MutableLiveData<String>("Обобщённые")
}