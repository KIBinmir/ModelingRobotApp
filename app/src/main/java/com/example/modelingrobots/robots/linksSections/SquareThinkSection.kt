package com.example.modelingrobots.robots.linksSections

class SquareThinkSection: SquareFullSection() {
    override fun mass(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return super.mass(material, l, p1, p2, p3=0.0) - super.mass(material, l, p1-2*p3, p2-2*p3, p3=0.0)
    }

    override fun inertionc(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return super.inertionc(material, l, p1, p2, p3) - super.inertionc(material, l, p1-2*p3, p2-2*p3, p3)
    }
}