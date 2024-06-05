package com.example.modelingrobots.robots.dynamics

class DynamicRobotKoler(m1: Double, m2: Double, J2: Double, l1: Double, l2: Double): DynamicRobot(m1, m2, 1.0, J2, l1, l2) {
    val r2 = l2/2
    override fun Dyn1(M1: Double, M2: Double): Double {
        val a1 = m1 + m2
        val a2 = m2*r2
        val b1 = a2*Math.sin(q2)
        val b2 = a2*Math.cos(q2)
        val a3 = m2*r2*r2 + J2
        return delta(M1-b2*dq2*dq2,b1, M2, a3) / delta(a1, b1, b1, a3)
    }
    override fun Dyn2(M2: Double, M1: Double): Double {
        val a1 = m1 + m2
        val a2 = m2*r2
        val b1 = a2*Math.sin(q2)
        val b2 = a2*Math.cos(q2)
        val a3 = m2*r2*r2 + J2
        return delta(a1, M1-b2*dq2*dq2, b1, M2) / delta(a1, b1, b1, a3)
    }
}