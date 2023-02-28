package codeStates;

interface CafeCustomer{
    public abstract String getOrder();
}

class CafeCustomerA implements CafeCustomer{
    @Override
    public String getOrder() {
        return "a glass of iced americano";
    }
}

class CafeCustomerB implements CafeCustomer{
    @Override
    public String getOrder() {
        return "a glass of strawberry latte";
    }
}

class CafeOwner{
    public void giveItem(CafeCustomer cafeCustomer){
        System.out.println("Item : "+cafeCustomer.getOrder());
    }
}


public class InterfaceExample2 {
    public static void main(String[] args) {
        CafeOwner cafeOwner = new CafeOwner();
        CafeCustomer cafeCustomerA = new CafeCustomerA();
        CafeCustomer cafeCustomerB = new CafeCustomerB();

        cafeOwner.giveItem(cafeCustomerA);
        cafeOwner.giveItem(cafeCustomerB);
        /*
            매개변수의 다형성에 의해 CafeCustomer를 통해 구현된 객체가 모두 들어올 수 있다.
            CafeOwner 클래스가 더이상 손님의 종류에 의존적인 클래스가 아닌 독립적인 기능을 수행하는 클래스가 됨.
         */
    }
}
