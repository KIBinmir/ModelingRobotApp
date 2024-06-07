package com.example.modelingrobots.robots.kinematics;

public class RobotCylindr extends Robot{
    public RobotCylindr(double l1, double l2, double q1min, double q1max, double q2min, double q2max) {
        super(l1, l2, q1min, q1max, q2min, q2max);
    }
    @Override
    public double calcQ1(Double x1, Double y1) {
        return Math.atan2(x1, y1);
    }

    @Override
    public double calcQ2(Double x1, Double y1) {
        return Math.sqrt(x1*x1-y1*y1)-L1;
    }

    @Override
    public double calcX(Double q11, Double q22) {
        return (L1+q22)*Math.sin(q11);
    }

    @Override
    public double calcY(Double q11, Double q22) {
        return (L1+q22)*Math.cos(q11);
    }

    @Override
    public void correctQ1Q2Constraints() {
        q2Min = q2Min < 0.0 ? 0.0 : q2Min;
        q2Max = q2Max > L2 ? L2 : q2Max;
        q1Max = q1Max > Math.PI ? Math.PI : q1Max;
        q1Min = q1Min < -Math.PI ? -Math.PI : q1Min;
    }
}
