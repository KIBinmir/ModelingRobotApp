package com.example.modelingrobots.robots.linksSections

class CircleThinkSection: CircleFullSection() {
    override fun mass(material: Materials, l: Double, p1: Double, p2: Double, p3: Double ): Double {
        return super.mass(material, l, p1, p2=0.0, p3=0.0) - super.mass(material, l, p1-2*p2, p2=0.0, p3=0.0)
    }

    override fun inertionc(material: Materials, l: Double, p1: Double, p2: Double, p3: Double): Double {
        return super.inertionc(material, l, p1, p2=0.0, p3=0.0) - super.inertionc(material, l, p1-2*p1, p2=0.0, p3=0.0)
    }
}