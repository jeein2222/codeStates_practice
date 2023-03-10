package codeStates;
/*
    익명 객체
    익명 객체는 클래스를 상속하거나 인터페이스를 구현해야만 생성 가능, 클래스를 상속해서 만들 경우 익명 자식 객체,
    인터페이스를 구현해서 만들 경우 익명 구현 객체라고 함.
 */

class Tire{
    public void roll(){
        System.out.println("일반 타이어");
    }
}

class Car{
    private Tire tire1 = new Tire();
    private Tire tire2= new Tire(){
        @Override
        public void roll(){
            System.out.println("필드에 대입된 익명 자식 객체");
        }
    };

    public void run1(){
      tire1.roll();
      tire2.roll();
    }

    public void run2(){
        Tire tire=new Tire(){
            @Override
            public void roll() {
                System.out.println("로컬 변수에 대입된 익명 자식 객체");
            }
        };
        tire.roll();
    }

    public void run3(Tire tire){
        tire.roll();
    }
}
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Car car = new Car();
        car.run1();
        car.run2();
        car.run3(new Tire(){
            @Override
            public void roll() {
                System.out.println("매개변수에 전달된 익명 자식 객체");
            }
        });
    }
}




