package com.example.modelingrobots.robots.dynamics

class DynamicRobotCylindr(m1: Double, m2: Double,  J1: Double, J2: Double, l1: Double, l2: Double): DynamicRobot(m1, m2, J1, J2, l1, l2) {
    val Jo1 = J1 + m1*(l1/2)*(l1/2)
    override fun Dyn1(M1: Double, M2: Double): Double {
        return (super.Dyn1(M1, M2) - 2*m2*(l1 - l2/2 + q2)*dq1*dq2)/(Jo1 + J2 + m2*(l1 - l2/2 + q2)*(l1 - l2/2 + q2))
    }
    override fun Dyn2(M2: Double, M1: Double): Double {
        return (super.Dyn2(M2, M1) + m2*(l1 - l2/2 + q2)*dq2*dq2)/m2
    }
}