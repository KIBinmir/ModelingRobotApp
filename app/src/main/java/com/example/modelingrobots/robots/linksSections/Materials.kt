package com.example.modelingrobots.robots.linksSections

enum class Materials(val _density: Double, val _nameMaterial: String) {
    Aluminum(2700.0, "Аллюминий"),
    Plastic(1050.0, "Пластмасса"),
    Steel(7800.0,"Сталь");

    val density get() = _density
    val nameMaterial get() = _nameMaterial
}