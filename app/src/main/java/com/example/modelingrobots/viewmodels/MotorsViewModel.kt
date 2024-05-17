package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MotorsViewModel : ViewModel() {
    val u1max = MutableLiveData<String>("")
    val u2max = MutableLiveData<String>("")
    val n1 = MutableLiveData<String>("")
    val n2 = MutableLiveData<String>("")
    val kq1 = MutableLiveData<String>("")
    val kq2 = MutableLiveData<String>("")
    val ku1 = MutableLiveData<String>("")
    val ku2 = MutableLiveData<String>("")
    val j1 = MutableLiveData<String>("")
    val j2 = MutableLiveData<String>("")

}