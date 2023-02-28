package codeStates.polymorphism;

class Bank{
    void deposit(Person person,int money){
        person.setMoney(person.getMoney()+money);
        System.out.println(person.getName()+"님의 잔액은 "+person.getMoney()+"원 입니다.");
    }

    void withdraw(Person person, int money){
        if(person.getMoney()<money){
            System.out.println(person.getName()+"님, 인출 불가합니다.");
        }else{
            person.setMoney(person.getMoney()-money);
            System.out.println(person.getName()+"님의 잔액은 "+person.getMoney()+"원 입니다.");
        }
    }
}
/*
    다형성을 구현하는 것에는 상속관계에 있는 클래스들에서 상위 클래스 타입의 참조 변수가 하위 클래스 객체를
    참조할 수 있는 것이며, 이때 하위 클래스는 상위 클래스의 멤버들을 서로 다르게 확장하고 있으므로(메소드 오버라이딩,
    메소드 오버로딩) 해당 참조변수를 사용하면 서로 다른 결과가 나타난다.(이때 다형성에는 필드 다형성과
    매개변수 다형성이 있다)
 */

public class Main {
    public static void main(String[] args) {
        //매개변수의 다형성
        Bank bank=new Bank();
        Person person1 = new Musician("Jax", false);//10000
        Person person2 = new PersonalTrainer("James", 10);//20000
        Person person3 = new Programmer("Jeein", true);//30000

        bank.deposit(person1,3000);
        bank.deposit(person2,5000);
        bank.deposit(person3,2000);

        bank.withdraw(person1,2000);
        bank.withdraw(person2,3000);
        bank.withdraw(person3,1000);

        //인터페이스 참조 변수의 다형성
        Hyodoable p1 = new Musician("IU", false);
        Hyodoable p2=new PersonalTrainer("김계란",10);
        Hyodoable p3 = new Programmer("Tom", false);


    }
}
