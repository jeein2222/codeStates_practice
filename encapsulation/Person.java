package codeStates.encapsulation;

public class Person {
    private String name;
    private Car car;

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public void sleep(){
        System.out.printf("%s가 잠을 잡니다.\n", name);
    }
    public void eat(){
        System.out.printf("%s가 밥을 먹습니다.\n", name);
    }
    public void introduce(){
        System.out.printf("안녕하세요. 저는 %s입니다.\n",name);
    }
    public void drive(){
        car.operate();
    }
}
