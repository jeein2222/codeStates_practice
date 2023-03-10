package codeStates.inheritance;

class Vehicle{
    void run(){
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle{
    void run(){
        System.out.println("Bike is running");
    }
}

class MotorBike extends Vehicle{
    void run(){
        System.out.println("MotorBike is running");
    }
}


public class MethodOverridingExample {
    public static void main(String[] args) {

    }
}
