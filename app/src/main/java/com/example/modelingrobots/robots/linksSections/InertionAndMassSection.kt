package com.example.modelingrobots.robots.linksSections

interface InertionAndMassSection {
    fun mass(material: Materials, l: Double, p1: Double, p2: Double = 0.0, p3: Double = 0.0): Double
    fun inertionc(material: Materials, l: Double, p1: Double, p2: Double = 0.0, p3: Double = 0.0): Double
}