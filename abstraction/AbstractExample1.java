package codeStates;

abstract class Animal{//추상 클래스
    public String kind;
    abstract void sound();//추상 메서드
    abstract void run();
}

class Dog extends Animal {
    public Dog() {
        this.kind = "포유류";
    }

    @Override
    void sound() {
        System.out.println("멍멍");
    }

    @Override
    void run() {

    }

}

class Cat extends Animal{
    public Cat(){
        this.kind = "포유류";
    }

    @Override
    void sound() {
        System.out.println("야옹");
    }

    @Override
    void run() {

    }

}

public class AbstractExample1 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();

        Animal cat = new Cat();
        cat.sound();
    }
}
