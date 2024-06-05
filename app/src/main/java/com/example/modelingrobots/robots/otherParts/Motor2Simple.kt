package com.example.modelingrobots.robots.otherParts

class Motor2Simple(J: Double, L: Double, R: Double, km: Double, ke: Double) : Motor2(J, L, R, km, ke) {
    override fun sim(u: Double, dt: Double): Double {
        ddoutput = (k*u - doutput)/Tm
        doutput += ddoutput*dt
        output += doutput*dt
        return output
    }
}