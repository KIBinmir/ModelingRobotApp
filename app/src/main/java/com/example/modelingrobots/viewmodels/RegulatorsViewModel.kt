package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegulatorsViewModel : ViewModel() {
    val kp1 = MutableLiveData<String>("1.0")
    val ki1 = MutableLiveData<String>("0.0")
    val kd1 = MutableLiveData<String>("0.0")
    val kp2 = MutableLiveData<String>("1.0")
    val ki2 = MutableLiveData<String>("0.0")
    val kd2 = MutableLiveData<String>("0.0")
}