package com.example.modelingrobots.robots.otherParts

open class Motor(J: Double, L: Double, R: Double, km: Double, ke: Double, n: Double=0.0) {
    var dddoutput = 0.0
    var ddoutput = 0.0
    var doutput = 0.0
    var output = 0.0
    val a0 = J*L/(R*n*R*n)
    val a1 = J*n*n
    val a2 = L/R+km*ke*n*n
    val a3 = 1.0
    val b3 = km/(R*n)

    open fun sim(u: Double, dt: Double = 0.01): Double {
        dddoutput = (b3*u - a1*ddoutput-a2*doutput-a3*output)/a0
        ddoutput += dddoutput*dt
        doutput += ddoutput*dt
        output += doutput
        return output
    }

}