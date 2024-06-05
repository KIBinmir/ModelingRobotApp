package com.example.modelingrobots.robots.dynamics

open class DynamicRobot(val m1: Double, val m2: Double, val J1: Double=1.0, val J2: Double = 1.0, val l1: Double = 1.0, val l2: Double = 1.0) {
    var ddq1 = 0.0
    var dq1 = 0.0
    var q1 = 0.0
    var q2 = 0.0
    var dq2 = 0.0
    var ddq2 = 0.0

    open fun Dyn1(M1: Double, M2: Double = 0.0): Double {
        return M1
    }
    open fun Dyn2(M2: Double, M1: Double=0.0): Double {
        return M2
    }

    open fun delta(a11: Double, a12: Double, a21: Double, a22: Double): Double {
        return a11*a22 - a12*a21
    }
    open fun sim(M1: Double, M2: Double, dt: Double = 0.01): List<Double> {
        ddq1 = Dyn1(M1, M2)
        ddq2 = Dyn2(M2, M1)
        dq1 += ddq1*dt
        dq2 += ddq2*dt
        q1 += dq1*dt
        q2 += dq2*dt
        return listOf(q1, q2)
    }
}