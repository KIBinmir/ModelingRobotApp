package com.example.modelingrobots.robots.linksSections

open class SquareFullSection: InertionAndMassSection {
    override fun mass(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return l*p1*p2*material.density
    }

    override fun inertionc(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return this.mass(material, l, p1, p2) * (l*l + p1*p1)/12
    }
}