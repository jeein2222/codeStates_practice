package codeStates;

class Person{
    String name;
    int age;

    void learn(){
        System.out.println(name+"는 공부를 합니다.");
    }

    void walk(){
        System.out.println(name+"는 걷습니다.");
    }

    void eat(){
        System.out.println(name+"는 먹습니다");
    }
}

class Programmer extends Person{
    String companyName;
    void coding(){
        System.out.println(name+"는 " +companyName+"에서 코딩합니다.");
    }
}

class Dancer extends Person{
    String groupName;
    void dancing(){
        System.out.println(name+"는 "+groupName+"에서 춤을 춥니다.");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Jame";
        p.age=20;
        p.eat();
        p.walk();
        p.learn();

        Programmer pg = new Programmer();
        pg.name = "Amy";
        pg.age=25;
        pg.companyName = "Google";
        pg.eat();
        pg.walk();
        pg.learn();
        pg.coding();

        Dancer d = new Dancer();
        d.name = "Tom";
        d.age=20;
        d.groupName = "HighSchoolMusical";
        d.eat();
        d.walk();
        d.learn();
        d.dancing();

        /*
            Jame는 먹습니다
            Jame는 걷습니다.
            Jame는 공부를 합니다.
            Amy는 먹습니다
            Amy는 걷습니다.
            Amy는 공부를 합니다.
            Amy는 Google에서 코딩합니다.
            Tom는 먹습니다
            Tom는 걷습니다.
            Tom는 공부를 합니다.
            Tom는 HighSchoolMusical에서 춤을 춥니다.
         */

    }
}
