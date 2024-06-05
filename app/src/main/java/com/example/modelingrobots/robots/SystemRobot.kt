package com.example.modelingrobots.robots

import com.example.modelingrobots.robots.dynamics.DynamicRobot
import com.example.modelingrobots.robots.otherParts.Motor2Simple
import com.example.modelingrobots.robots.otherParts.PID

class SystemRobot(val reg1: PID, val reg2: PID, val motor1: Motor2Simple, val motor2: Motor2Simple, val robotDynamics: DynamicRobot) {
    var q1 = 0.0
    var q2 = 0.0
    var t = 0.0
    val maxQ = 100.0
    fun sim(q1z: Double, q2z: Double, dt: Double = 0.0): List<Double> {
        val e1 = q1z - q1
        val e2 = q2z - q2
        val u1 = reg1.sim(e1, dt)
        val u2 = reg1.sim(e2, dt)
        val m1 = motor1.sim(u1, dt)
        val m2 = motor2.sim(u2, dt)
        val qlst = robotDynamics.sim(m1, m2, dt)
        q1 = qlst[0]
        q2 = qlst[1]
        t += dt
        return listOf(t, q1, q2)
    }
    fun setStart(q1z: Double, q2z: Double) {
        q1 = q1z
        q2 = q2z
    }
    fun isStableProcess() = (Math.abs(q1) < maxQ) or (Math.abs(q2) < maxQ)
}