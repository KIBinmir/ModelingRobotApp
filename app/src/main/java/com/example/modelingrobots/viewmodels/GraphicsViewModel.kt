package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GraphicsViewModel: ViewModel() {
    val data = MutableLiveData<List<String>>()
    val typeCoordinates = MutableLiveData<String>("Обобщённые")
    val isVisibleQ1 = MutableLiveData<Boolean>(true)
    val isVisibleQ2 = MutableLiveData<Boolean>(true)
    val isVisibleX = MutableLiveData<Boolean>(true)
    val isVisibleY = MutableLiveData<Boolean>(true)
    val isShowPlanarTrajectory = MutableLiveData<Boolean>(false)
}