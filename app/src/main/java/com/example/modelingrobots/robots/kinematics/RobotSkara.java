package com.example.modelingrobots.robots.kinematics;

public class RobotSkara extends Robot{
    public enum OrientationLink {
        LEFT(1.0),
        RIGHT(-1.0);

        double orientation;
        OrientationLink(double orientation) {
            this.orientation = orientation;
        }
        public double getOrientation() {
            return this.orientation;
        }
    }

    OrientationLink orientationLink = OrientationLink.LEFT;

    public RobotSkara(double l1, double l2, double q1min, double q1max, double q2min, double q2max) {
        super(l1, l2, q1min, q1max, q2min, q2max);
    }
    @Override
    public double calcQ1(Double x1, Double y1) {
        double r = Math.sqrt(x1*x1 + y1*y1);
        double a = Math.atan2(y1,x1);
        double g1 = Math.acos((r*r + L1*L1 - L2*L2)/(2*L1*r));
        return -Math.PI/2+a+g1*orientationLink.getOrientation();
    }

    @Override
    public double calcQ2(Double x1, Double y1) {
        double r = Math.sqrt(x1*x1 + y1*y1);
        double g1 = Math.acos((r*r + L1*L1 - L2*L2)/(2*L1*r));
        double g2 = Math.asin(L1/L2*Math.sin(g1));
        return (g1+g2)*orientationLink.getOrientation();
    }

    @Override
    public double calcX(Double q11, Double q22) {
        return -L1*Math.sin(q11)-L2*Math.sin(q11+q22);
    }

    @Override
    public double calcY(Double q11, Double q22) {
        return L1*Math.cos(q11)+L2*Math.cos(q11+q22);
    }

    public void setOrientation(OrientationLink orientation) {
        orientationLink = orientation;
    }

    @Override
    public void correctQ1Q2Constraints() {
        q2Min = q2Min < -Math.PI ? -Math.PI : q2Min;
        q2Max = q2Max > Math.PI ? Math.PI : q2Max;
        q1Max = q1Max > Math.PI ? Math.PI : q1Max;
        q1Min = q1Min < -Math.PI ? -Math.PI : q1Min;
    }
}
