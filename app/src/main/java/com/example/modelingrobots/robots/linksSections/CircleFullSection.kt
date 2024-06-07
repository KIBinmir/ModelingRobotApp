package com.example.modelingrobots.robots.linksSections

open class CircleFullSection : Section() {
    override fun mass(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return material.density*l*Math.PI*p1*p1/4
    }

    override fun inertionc(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return this.mass(material, l, p1) * (l * l / 12 + p1 * p1 / 16)
    }
}