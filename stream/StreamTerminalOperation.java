package codeStates.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

//스트림 최종 연산*
public class StreamTerminalOperation {
    public static void main(String[] args) {
        //1.기본 집계
        int[] intArray = {1, 2, 3, 4, 5};

        //카운팅
        long count= Arrays.stream(intArray).count();
        System.out.println("count : " + count);

        //합계
        long sum = Arrays.stream(intArray).sum();
        System.out.println("sum : " + sum);

        //평균
        double average = Arrays.stream(intArray).average().getAsDouble();
        System.out.println("average : " + average);

        //평균 -> getAsDouble()은 최종 연산과는 관계 없다! 자료형을 변환해줄 뿐
        OptionalDouble average2 = Arrays.stream(intArray).average();
        System.out.println(average2);//OptionalDouble[3.0]
        double result = average2.getAsDouble();
        System.out.println("average2 : "+result);//average2 : 3.0


        //최대값
        int max = Arrays.stream(intArray).max().getAsInt();
        System.out.println("max : " +max);

        //최소값
        int min = Arrays.stream(intArray).min().getAsInt();
        System.out.println("min : " + min);

        //배열의 첫 번째 요소
        int first = Arrays.stream(intArray).findFirst().getAsInt();
        System.out.println("first element : "+first);

        System.out.println("-".repeat(60));

        //2.매칭 : 조건식 람다 Predicate를 매개변수로 넘겨 스트림의 각 데이터 요소들이 특정 조건을 만족하는지 여부를 boolean으로 리턴
        int[] intArray2 = {2, 4, 6};

        //allMatch()
        boolean isAllEven=Arrays.stream(intArray2).allMatch(e->e%2==0);
        System.out.println("요소 모두 2의 배수인가? " + isAllEven);//true

        //noneMatch()
        boolean isAllNotEven=Arrays.stream(intArray2).noneMatch(e->e%2==0);
        System.out.println("요소 모두 2의 배수가 아닌가? "+isAllNotEven);//false

        //anyMatch()
        boolean isAnyEven = Arrays.stream(intArray2).anyMatch(e -> e % 2 == 0);
        System.out.println("요소 중 하나라도 2의 배수가 있는가? "+isAnyEven);//true

        System.out.println("-".repeat(60));

        //3. reduce() : 스트림의 요소를 줄여나가면서 연산으 수행하고 최종 결과 반환
        int[] intArray3 = {1, 2, 3, 4, 5};

        //초기값이 없는 reduce()
        int sum2 = Arrays.stream(intArray3)
                .map(e -> e * 2)
                .reduce((a, b) -> a + b)
                .getAsInt();
        System.out.println("초기값이 없는 reduce() : " + sum2);

        //초기값이 있는 reduce()
        int sum3=Arrays.stream(intArray3)
                .map(e->e*2)
                .reduce(5, (a,b)->a+b);
        System.out.println("초기값이 있는 reduce() : " + sum3);

        System.out.println("-".repeat(60));


        //4.collect() : 스트림 요소들을 List, Set, Map 등 다른 타입의 결과로 수집하고 싶은 경우.
        List<Student> totalList = Arrays.asList(
                new Student("김코딩", 100, Student.Gender.Male),
                new Student("박해커", 90, Student.Gender.Male),
                new Student("이자바", 80, Student.Gender.Female),
                new Student("김자바", 100, Student.Gender.Male),
                new Student("박자바", 70, Student.Gender.Female)

        );

        //스트링 연산 결과를 Map으로 변환
        Map<String, Integer> maleMap = totalList.stream()
                .filter(s -> s.getGender() == Student.Gender.Male)
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> student.getScore()
                ));
        System.out.println(maleMap);//{김코딩=100, 김자바=100, 박해커=90}

        //스트링 연산 결과를 List로 변환
        List<String> femaleList=totalList.stream()
                .filter(s->s.getGender()==Student.Gender.Female)
                .map(e->e.toString())
                .collect(Collectors.toList());

        System.out.println(femaleList);//[이자바's score : 80 Gender : Female, 박자바's score : 70 Gender : Female]
    }
}

class Student{
    public enum Gender {Male, Female};
    private String name;
    private int score;
    private Gender gender;

    public Student(final String name, final int score, final Gender gender) {
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return getName() + "'s score : " + getScore() + " Gender : " + getGender();
    }
}