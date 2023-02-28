package codeStates.polymorphism;

public class PersonalTrainer extends Person implements Hyodoable{
    private int awards;

    public PersonalTrainer(String name, int awards) {
        super(name,20000);
        this.awards = awards;
    }

    public void teach(){
        System.out.println("PT를 합니다.");
    }

    @Override
    public void hyodo() {
        System.out.println("부모님께 운동을 가르쳐드립니다.");
    }
}
