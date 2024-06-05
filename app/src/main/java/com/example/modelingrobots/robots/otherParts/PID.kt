package com.example.modelingrobots.robots.otherParts

class PID(kp1: Double=1.0, kd1: Double=0.0, ki1:Double=0.0) {
    var output = 0.0
    var error: Double = 0.0
    var sumError: Double = 0.0
    val kp = kp1
    val kd = kd1
    val ki = ki1
    fun sim(input: Double, dt:Double=0.01):Double {
        val de = kd*(input - error)/dt
        sumError += ki*input*dt
        error = input
        output = kp*input + de + sumError
        return output
    }
}