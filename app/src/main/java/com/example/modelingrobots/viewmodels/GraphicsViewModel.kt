package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelingrobots.ItemTimeTable

class GraphicsViewModel: ViewModel() {
    val data = MutableLiveData<List<ItemTimeTable>>()
    val typeCoordinates = MutableLiveData<String>("Обобщённые")
    val isShowPlanarTrajectory = MutableLiveData<Boolean>(false)
}