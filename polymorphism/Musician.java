package codeStates.polymorphism;

public class Musician extends Person implements Hyodoable{
    private boolean isGroup;

    public Musician(String name, boolean isGroup) {
        super(name,10000);
        this.isGroup = isGroup;
    }

    public void perform(){
        System.out.println("공연을 합니다.");
    }

    @Override
    public void hyodo() {
        System.out.println("부모님께 노래를 불러 드립니다.");
    }
}
