package codeStates.encapsulation;

public class Programmer extends Person{
    private String company;
    private boolean tooMuchWork;

    public Programmer(String name, Car car, String company, boolean tooMuchWork) {
        super(name, car);
        this.company = company;
        this.tooMuchWork = tooMuchWork;
    }

    public void work(){
        System.out.println("근무 시작");
        System.out.println("타닥타닥");
        System.out.println();
    }
    public void commute(){
        System.out.printf("%s를 타고 출근합니다.\n",super.getCar().getName());
        super.drive();
        System.out.printf("%s에 도착했습니다.\n", company);
        System.out.println();
    }
    public void eat(){
        if(tooMuchWork) System.out.println("허겁지겁");
        else super.eat();
        System.out.println();
    }

    public void sleep(){
        if(tooMuchWork) System.out.println("잠을 잘 수 없습니다...");
        else super.sleep();
        System.out.println();
    }

    public void introduce(){
        super.introduce();
        System.out.printf("%s에서 일하고 있으며, %s",
                company,
                tooMuchWork ? "오늘은 야근을 합니다...\n":"오늘은 정시 퇴근!!입니다.\n");
        System.out.println();
    }
}
