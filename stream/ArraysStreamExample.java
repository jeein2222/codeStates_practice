package codeStates.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//배열 스트림 생성
public class ArraysStreamExample {
    public static void main(String[] args) {
        //문자열 배열 선언 및 할당
        String[] arr = new String[]{"김코딩", "이자바", "박해커"};

        //문자열 스트림 생성 -> 두 가지 방법 Arrays.stream(), Stream.of()
//        Stream<String> stream = Arrays.stream(arr);
        Stream<String> stream = Stream.of(arr);

        //출력
        stream.forEach(System.out::println);

        //Arrays 클래스에는 기본형 배열을 데이터 소스로 스트림을 생성하는 메서드도 있음
        //IntStream, DoubleStream, LongStream -> 숫자와 관련된 유용한 메서드들 정의되어 있음.
        double[] doubleArr = {1.0, 2.0, 3.2};
        DoubleStream doubleStream = Arrays.stream(doubleArr);
        double average = doubleStream.average().getAsDouble();


        //IntStream의 유용한 기능들
        //int 배열로 스트림 생성
        int[] intArr = {1, 2, 3, 4, 5, 6};
        IntStream intStream = Arrays.stream(intArr);

        //숫자와 관련된 경우 intStream을 사용하는 것을 권장
        System.out.println("sum="+intStream.sum());
//        System.out.println("average="+intStream.average()); -> sum() 메서드 호출 후 stream이 닫히기 때문에  에러 발생

    }
}
