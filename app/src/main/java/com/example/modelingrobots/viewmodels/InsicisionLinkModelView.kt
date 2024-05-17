package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InsicisionLinkModelView: ViewModel() {
    val typeLink = MutableLiveData<String>("Круглое кольцевое")
    val materialLink = MutableLiveData<String>("Аллюминий")
    val p1 = MutableLiveData<String>("0.05")
    val p2 = MutableLiveData<String>("0.05")
    val p3 = MutableLiveData<String>("0.05")
}