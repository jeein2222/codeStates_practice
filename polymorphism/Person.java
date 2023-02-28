package codeStates.polymorphism;

public class Person {
    private String name;
    private int money;

    public Person(String name,int money) {
        this.name = name;
        this.money=money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void sleep(){
        System.out.println("쿨쿨쿨");
    }

    public void eat(){
        System.out.println("냠냠냠");
    }
}
