package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modelingrobots.robots.linksSections.CircleFullSection
import com.example.modelingrobots.robots.linksSections.CircleThinkSection
import com.example.modelingrobots.robots.linksSections.InertionAndMassSection
import com.example.modelingrobots.robots.linksSections.Materials
import com.example.modelingrobots.robots.linksSections.Section
import com.example.modelingrobots.robots.linksSections.SquareFullSection
import com.example.modelingrobots.robots.linksSections.SquareThinkSection

class InsicisionLinkViewModel: ViewModel() {
    val typeLink = MutableLiveData<String>("Круглое сплошное")
    val materialLink = MutableLiveData<Materials>(Materials.Aluminum)
    val p1 = MutableLiveData<Double>(3.50)
    val p2 = MutableLiveData<Double>(0.05)
    val p3 = MutableLiveData<Double>(0.05)
    var section: Section = when(typeLink.value) {
        "Круглое сплошное" -> CircleFullSection()
        "Круглое кольцевое" -> CircleThinkSection()
        "Прямоугольное сплошное" -> SquareFullSection()
        "Прямоугольное тонкостенное" -> SquareThinkSection()
        else -> CircleFullSection()
    }



    fun setValues(tLink: String, matLink: Materials, p11: Double=0.05, p22: Double=0.05, p33: Double= 0.05) {
        typeLink.value = tLink
        materialLink.value = matLink
        p1.value = p11
        p2.value = p22
        p3.value = p33
        when(typeLink.value) {
            "Круглое сплошное" -> section = CircleFullSection()
            "Круглое кольцевое" -> section = CircleThinkSection()
            "Прямоугольное сплошное" -> section = SquareFullSection()
            "Прямоугольное тонкостенное" -> section = SquareThinkSection()
        }
    }
    fun getMassInertion(l:Double): List<Double> {
        return listOf<Double>(section.mass(materialLink.value!!,l,p1.value!!, p2.value!!, p3.value!!),
            section.inertionc(materialLink.value!!,l,p1.value!!, p2.value!!, p3.value!!))
    }
}