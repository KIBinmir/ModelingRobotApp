package com.example.modelingrobots.robots.otherParts

open class Motor2(J: Double, L: Double, R: Double, km: Double, ke: Double): Motor(J, L, R, km, ke) {
    val k = 1/ke
    val Tm = J*R/(ke*km)
    val Te = L/R
    override fun sim(u: Double, dt: Double): Double {
        dddoutput = (k*u - Tm*ddoutput - ddoutput)/Tm/Te
        ddoutput += dddoutput*dt
        doutput += ddoutput*dt
        output += doutput
        return output
    }
}