package codeStates.encapsulation;

public class Car {
    private String name;
    private int fuelPercent;

    public Car(String name, int fuelPercent) {
        this.name = name;
        this.fuelPercent = fuelPercent;
    }

    public String getName() {
        return name;
    }

    public int getFuelPercent() {
        return fuelPercent;
    }

    public void setFuelPercent(int fuelPercent) {
        this.fuelPercent = fuelPercent;
    }

    private void on(){ //외부에 노출X. 내용이 변경되더라도 상관 X도록
        System.out.println(name+"에 시동을 겁니다.");
    }

    private void go(){
        System.out.println("부릉부릉");
    }

    private void off(){
        System.out.println("시동을 끕니다.");
    }

    public void operate(){//연료 체크 기능을 Car 클래스에 두어서 객체의 자율성을 높임.
        if(getFuelPercent()<=0) System.out.println("연료부족으로 시동을 걸 수 없습니다.");
        else {
            on();
            go();
            off();
        }
    }

}
