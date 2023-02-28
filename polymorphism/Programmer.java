package codeStates.polymorphism;

public class Programmer extends Person implements Hyodoable{
    private boolean hasTooMuchWork;

    public Programmer(String name,boolean hasTooMuchWork) {
        super(name,30000);
        this.hasTooMuchWork=hasTooMuchWork;
    }

    public void work(){
        System.out.println("타닥 타닥");
    }

    @Override
    public void hyodo() {
        System.out.println("부모님 컴퓨터를 고쳐드립니다.");
    }
}
