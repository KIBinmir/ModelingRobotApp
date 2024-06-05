package com.example.modelingrobots.robots.dynamics

class DynamicRobotDekart(m1: Double, m2: Double): DynamicRobot(m1, m2) {
    override fun Dyn1(M1: Double, M2: Double): Double {
        return super.Dyn1(M1, M2)/(m1 + m2)
    }

    override fun Dyn2(M2: Double, M1: Double): Double {
        return super.Dyn1(M2, M1)/m2
    }

}