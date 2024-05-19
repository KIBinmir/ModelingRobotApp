package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParametersRobotsViewModel: ViewModel() {
    val typeRobot = MutableLiveData<String>("Декарт")
    val l1 = MutableLiveData<String>("1.0")
    val l2 = MutableLiveData<String>("1.0")
    val q1min = MutableLiveData<String>("1.0")
    val q1max = MutableLiveData<String>("1.0")
    val q2min = MutableLiveData<String>("1.0")
    val q2max = MutableLiveData<String>("1.0")

}