package com.example.modelingrobots;

public enum TypeRobot {
    DEKART(),
    CYLINDR(),
    KOLER(RobotKoler),
    SKARA(RobotSkara());

    Robot robot;

    TypeRobot(Robot robot) {
        this.robot = robot;
    }
    
}
