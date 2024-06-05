package com.example.modelingrobots.robots.dynamics

class DynamicRobotSkara(m1: Double, m2: Double,  J1: Double, J2: Double, l1: Double, l2: Double): DynamicRobot(m1, m2, J1, J2, l1, l2) {
    val Jo1 = J1 + m1*(l1/2)*(l1/2)
    val r2 = l2/2
    override fun Dyn1(M1: Double, M2: Double): Double {
        val a1 = Jo1 + J2 + m2*(l1*l1 +r2*r2)
        val a2 = m2*l1*r2*Math.cos(q2)
        val a3 = J2 + m2*r2*r2
        val b1 = m2*l1*r2*Math.sin(q2)
        return delta(M1+b1*dq2*(2*dq1+dq2),a3+a2, M2-b1*dq1*dq1, a3) / delta(a1+2*a2, a3+a2, a3+a2, a3)
    }
    override fun Dyn2(M2: Double, M1: Double): Double {
        val a1 = Jo1 + J2 + m2*(l1*l1 +r2*r2)
        val a2 = m2*l1*r2*Math.cos(q2)
        val a3 = J2 + m2*r2*r2
        val b1 = m2*l1*r2*Math.sin(q2)
        return delta(a1+2*a2,M1+b1*dq2*(2*dq1+dq2), a3+a2, M2-b1*dq1*dq1) / delta(a1+2*a2, a3+a2, a3+a2, a3)
    }
}