package codeStates;

/*
    Generic은 클래스나 메서드의 코드를 작성할 때, 타입을 구체적으로 지정하는 것이 아니라, 추후에 지정할 수 있도록 일반화해두는 것.
    작성한 클래스 또는 메서드가 특정 데이터 타입에 얽매이지 않게 하는 것.
 */

class Basket1<T>{//T : 타입 매개변수
    private T item;

    public Basket1(final T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(final T item) {
        this.item = item;
    }
}

class Basket2<K,V>{
    private K item1;
    private V item2;

    public Basket2(final K item1, final V item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Basket1<String> basket1 = new Basket1<>("Apple");
        Basket1<Integer> basket2 = new Basket1<>(10);

        Basket2<String, Integer> basket3 = new Basket2<>("Apple", 10);
    }


}
