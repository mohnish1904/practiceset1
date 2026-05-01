package org.example.designpattern.creational.factory_pattern;

public class Car implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("This is a car.");
    }
}
