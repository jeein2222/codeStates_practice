package codeStates.encapsulation;
/*
    캡슐화란 특정 객체 내부의 필드와 메서드를 하나의 캡슐로 만들어 외부로 부터 데이터를 보호한다.
    접근 지정자와 getter,setter를 이용한 정보 은닉을 통해 높은 응집도가 낮은 결합도를 유지하고,
    각 클래스의 역할을 명확히 하여, 객체의 자율성을 높인다.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("James님의 하루");
        Car c = new Car("페라리", 100);
        Person james = new Person("james", c);
        james.introduce();
        james.eat();
        james.drive();
        james.sleep();

        System.out.println("-----------------------------");

        System.out.println("🤪Jeein님의 하루");
        Car cc = new Car("Jeep", 80);
        Programmer jeein = new Programmer("Jeein", cc, "Google", true);
        jeein.introduce();
        jeein.commute();
        jeein.work();
        jeein.eat();
        jeein.sleep();
    }
}
