package codeStates;
//다형성 예제 -> 매개변수의 다형성(상위 클래스 타입의 매개변수)
class Coffee{
    int price;
    public Coffee(int price){
        this.price=price;
    }
}

class Americano extends Coffee {
    public Americano() {
        super(4500);
    }

    @Override
    public String toString() {
        return "Americano";
    }
};

class CaffeLatte extends Coffee{
    public CaffeLatte() {
        super(5000);
    }

    @Override
    public String toString() {
        return "CaffeLatte";
    }
};

class Customer {
    int money = 50000;

    void buyCoffee(Coffee coffee) {//매개변수의 다형성 -> 상위클래스 타입인 참조변수로 하위 클래스들을 참조
        if(money<coffee.price){
            System.out.println("잔액부족");
        }else{
            money -= coffee.price;
            System.out.println(coffee+"를 구매함.");
        }
    }
    /*
        매번 다른 타입의 참조변수를 매개변수로 전달해주어야 하는 번거로움을 훨씬 줄일 수 있다.
     */
}
public class PolymorphismExample2 {
    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.buyCoffee(new Americano());
        customer.buyCoffee(new CaffeLatte());
        System.out.println("현재 잔액은 "+customer.money+"원 입니다.");
    }
}
