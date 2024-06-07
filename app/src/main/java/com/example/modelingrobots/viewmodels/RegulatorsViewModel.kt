package com.example.modelingrobots.viewmodels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelingrobots.robots.otherParts.PID
import com.google.android.material.snackbar.Snackbar

class RegulatorsViewModel() : ViewModel() {
    val kp1 = MutableLiveData<Double>(1.0)
    val ki1 = MutableLiveData<Double>(0.0)
    val kd1 = MutableLiveData<Double>(0.0)
    val kp2 = MutableLiveData<Double>(1.0)
    val ki2 = MutableLiveData<Double>(0.0)
    val kd2 = MutableLiveData<Double>(0.0)
    var reg1: PID = PID(kp1.value!!, kd1.value!!, ki1.value!!)
    var reg2: PID = PID(kp2.value!!, kd2.value!!, ki2.value!!)

    fun setValues(kp11: Double, kd11: Double, ki11: Double, kp22: Double, kd22: Double, ki22: Double) {
        kp1.value = kp11
        kd1.value = kd11
        ki1.value = ki11
        kp2.value = kp22
        kd2.value = kd22
        ki2.value = ki22
        reg1 = PID(kp11, kd11, ki11)
        reg2 = PID(kp22, kd22, ki22)
    }
}