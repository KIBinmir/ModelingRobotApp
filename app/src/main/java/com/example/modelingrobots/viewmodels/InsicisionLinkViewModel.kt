package com.example.modelingrobots.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modelingrobots.databases.RobotsDao
import com.example.modelingrobots.databases.entities.Motors
import com.example.modelingrobots.databases.entities.SectionLinks
import com.example.modelingrobots.robots.linksSections.CircleFullSection
import com.example.modelingrobots.robots.linksSections.CircleThinkSection
import com.example.modelingrobots.robots.linksSections.InertionAndMassSection
import com.example.modelingrobots.robots.linksSections.Materials
import com.example.modelingrobots.robots.linksSections.Section
import com.example.modelingrobots.robots.linksSections.SquareFullSection
import com.example.modelingrobots.robots.linksSections.SquareThinkSection
import com.example.modelingrobots.robots.otherParts.Motor2Simple
import kotlinx.coroutines.launch

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
    fun getData(filename: String): SectionLinks {
        return SectionLinks(configuraionName = filename,
            typeSection = typeLink.value!!,
            material = materialLink.value!!.nameMaterial,
            param1 = p1.value!!,
            param2 = p2.value,
            param3 = p3.value)
    }
    fun updateViewModelFromDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            var sectionLinks = dao.getSectionLink(filename)[0]
            sectionLinks.apply {
                val mat = when(material) {
                    Materials.Aluminum.name -> Materials.Aluminum
                    Materials.Plastic.name -> Materials.Plastic
                    Materials.Steel.name -> Materials.Steel
                    else -> Materials.Aluminum
                }
                setValues(typeSection, mat, param1, param2!!, param3!!)
            }
        }
    }
    fun insertViewDataInDatabase(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.insertIncisionLink(getData(filename))
        }
    }
    fun updateDatabaseFromViewModel(dao: RobotsDao, filename: String) {
        viewModelScope.launch {
            dao.updateIncisionLink(getData(filename))
        }
    }
    fun setDefaultValue() {
        setValues("Круглое сплошное", Materials.Aluminum, 0.1, 0.0, 0.0)
    }
}