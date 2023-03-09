package codeStates.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

//스트림의 중간 연산
public class StreamIntermediateOperationExample {
    public static void main(String[] args) {
        //1. distince : 중복 제거
        List<String> names = Arrays.asList("김코딩", "이자바", "김해커","김코딩","박해커");
        names.stream()
                .distinct()
                .forEach(element-> System.out.print(element+" "));//김코딩 이자바 김해커 박해커
        System.out.println("\n"+"-".repeat(60));

        //2. filter : 조건(람다식 Predicate)에 맞는 데이터들만 정제하여 더 작은 컬렉션 만들어냄
        names.stream()
                .filter(element -> element.startsWith("김"))
                .forEach(element -> System.out.print(element+" "));//김코딩 김해커 김코딩

        System.out.println("\n"+"-".repeat(60));


        names.stream()
                .distinct()
                .filter(element -> element.startsWith("김"))
                .forEach(element -> System.out.print(element+" "));//김코딩 김해커

        System.out.println("\n"+"-".repeat(60));

        //2. map : 원하는 필드만 추출하거나 특정 형태로 변환할 때 사용
        List<String> students = Arrays.asList("Amy", "James", "Sara");
        students.stream()
                .map(element -> element.toUpperCase())
                .forEach(System.out :: print); //AMYJAMESSARA

        System.out.println("\n"+"-".repeat(60));

        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list.stream()
                .map(n->n*3)
                .mapToInt(e->e)
                .average().getAsDouble());

        System.out.println("-".repeat(60));

        //flatMap() : 중첩 구조를 제거하고 단일 컬렉션으로 만들어줌.
        String[][] namesArray = new String[][]{{"박해커", "이자바"}, {"김코딩", "나박사"}};
        //기존 방식
        Arrays.stream(namesArray)
                .map(e-> Arrays.stream(e))
                .forEach(name -> name.forEach(System.out::print));//박해커이자바김코딩나박사

        System.out.println("\n"+"-".repeat(60));

        //flatMap
        Arrays.stream(namesArray).
                flatMap(Arrays::stream)
                .forEach(System.out::print);//박해커이자바김코딩나박사

        System.out.println("\n"+"-".repeat(60));

        //3.sorted() : ()안에 Comparator라는 인터페이스에 정의된 static 메서드 or default 메서드를 사용하여 간편하게 정렬
        List<String> animals = Arrays.asList("Tiger", "Lion", "Monkey", "Duck");

        //인자값 없는 sort() 호출 -> 오름차순으로 정렬
        animals.stream().sorted().forEach(System.out::print);//DuckLionMonkeyTiger

        System.out.println("\n"+"-".repeat(60));

        //역순으로 정렬
        animals.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);//TigerMonkeyLionDuck

        System.out.println("\n"+"-".repeat(60));

        //문자열 길이순으로 정렬(오름차순)
        animals.stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::print);//LionDuckTigerMonkey

        System.out.println("\n"+"-".repeat(60));

        //4.skip(int n) : n개의 숫자를 건너뛰고
        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.skip(5).forEach(System.out::print);//678910

        System.out.println("\n"+"-".repeat(60));


        //5.limit(int n) : n개의 숫자까지
        IntStream intStream2 = IntStream.rangeClosed(1, 10);
        intStream2.limit(5).forEach(System.out::print);//12345

        System.out.println("\n"+"-".repeat(60));


        //6.peek(action) : 요소들을 순회하며 특정 작업(action) 수행
        IntStream intStream3 = IntStream.of(1,2,3,4,5);
        int sum=intStream3.filter(e->e%2==0)
                .peek(System.out::print)
                .sum();
        System.out.println("합계 : "+sum);//24합게 : 6 -> 짝수만 필터링해서 합계 구하기




    }
}
