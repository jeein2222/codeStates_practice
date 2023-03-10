package codeStates;

class Basket<T>{//1.여기서 선언한 타입 매개변수 T와
    private T item;

    public Basket(final T item) {
        this.item = item;
    }

    public <T> void getPrint(T element){//2.여기서 선언한 타입 매개변수 T는 서로 다름.
        System.out.println(element.equals(10));
    }
}

public class GenericMethodExample {
    public static void main(String[] args) {
        Basket<String> basket = new Basket<>("apple");
        basket.getPrint(10);//true
//        basket.<Integer>add(10);
    }
}
