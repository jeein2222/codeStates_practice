package codeStates.encapsulation;

/*
    getter,setter를 이용하면 외부로부터 데이터를 효과적으로 보호하면서 의도하는 값으로
    변경하여 캡슐화를 보다 효과적으로 달성가능하다!
 */
class Worker{
    private String name;//변수의 은닉화. 외부로부터 접근 불가
    private int age;
    private int id;

    public Worker(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class GetterAndSetterExample {
    public static void main(String[] args) {
        Worker w = new Worker("Amy", 23, 1);
        System.out.println("name : "+w.getName());
        System.out.println("age : "+w.getAge());
        System.out.println("id : " + w.getId());

        w.setAge(24);
        System.out.println("age changed to : "+w.getAge());

        /*
            name : Amy
            age : 23
            id : 1
            age changed to : 24
         */
    }
}
