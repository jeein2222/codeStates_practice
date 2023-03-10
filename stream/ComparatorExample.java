package codeStates.stream;

import java.util.Arrays;
import java.util.Comparator;

//Comparator, Comparable*
public class ComparatorExample {
    public static void main(String[] args) {
        Student2[] students1 = new Student2[]{
                new Student2("James", Gender.MALE, 1),
                new Student2("Sara", Gender.FEMALE, 6),
                new Student2("Amy", Gender.MALE, 5),
                new Student2("Tom", Gender.FEMALE, 2),
        };

        Student3[] students2 = new Student3[]{
                new Student3("James", Gender.MALE, 1),
                new Student3("Sara", Gender.FEMALE, 6),
                new Student3("Amy", Gender.MALE, 5),
                new Student3("Tom", Gender.FEMALE, 2),
        };

        /*
            객체를 비교할 때에는 2가지 방법이 있다..
         */

        //1. 비교하고자 하는 객체에 Comparable을 구현
        Arrays.stream(students1)
                .sorted()
                .forEach(student -> System.out.printf(
                        "%d : %s\n", student.getWash(), student.getName())
                );

        //2. 외부에서 Comparator 구현 객체를 만들어서 인자로 전달
        Comparator<Student3> comparator = new Comparator<Student3>() {
            @Override
            public int compare(Student3 o1, Student3 o2) {
//                if(o1.getWash() > o2.getWash()) return 1;
//                else if(o1.getWash() == o2.getWash()) return 0;
//                else return -1;
                return o1.getWash() - o2.getWash();
            }
        };

        Arrays.stream(students2)
                .sorted(comparator)
                .forEach(student -> System.out.printf(
                        "%d : %s\n", student.getWash(), student.getName())
                );

        //이렇게 축약
        Arrays.stream(students2)
                .sorted((o1,o2) -> o1.getWash() - o2.getWash())
                .forEach(student -> System.out.printf(
                        "%d : %s\n", student.getWash(), student.getName())
                );
    }
}

enum Gender{
    MALE,
    FEMALE
};

class Student2 implements Comparable<Student2>{
    private String name;
    private Gender gender;
    private int wash;

    public Student2(final String name, final Gender gender, final int wash) {
        this.name = name;
        this.gender = gender;
        this.wash = wash;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getWash() {
        return this.wash;
    }

    @Override
    public int compareTo(Student2 o) {
        //자기 자신의 어떤 값이 매개변수로 들어온 객체의 어떤 값보다
        //크다면 양수, 같다면 0, 작다면 음수를 리턴
        if(this.wash > o.wash) return 1;
        else if(this.wash == o.wash) return 0;
        else return -1;
    }
}

class Student3 {
    private String name;
    private Gender gender;
    private int wash;

    public Student3(final String name, final Gender gender, final int wash) {
        this.name = name;
        this.gender = gender;
        this.wash = wash;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getWash() {
        return this.wash;
    }

}