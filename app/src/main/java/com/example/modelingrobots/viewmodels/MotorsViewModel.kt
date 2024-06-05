package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelingrobots.robots.otherParts.Motor2Simple
import com.example.modelingrobots.robots.otherParts.PID

class MotorsViewModel : ViewModel() {
    val r1 = MutableLiveData<Double>(1.0)
    val r2 = MutableLiveData<Double>(1.0)
    val ke1 = MutableLiveData<Double>(1.0)
    val ke2 = MutableLiveData<Double>(1.0)
    val km1 = MutableLiveData<Double>(1.0)
    val km2 = MutableLiveData<Double>(1.0)
    val j1 = MutableLiveData<Double>(0.000001)
    val j2 = MutableLiveData<Double>(0.000001)
    val l1 = MutableLiveData<Double>(1.001)
    val l2 = MutableLiveData<Double>(1.001)

    lateinit var motor1: Motor2Simple
    lateinit var motor2: Motor2Simple

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
}