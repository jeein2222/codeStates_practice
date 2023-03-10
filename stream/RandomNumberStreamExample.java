package codeStates.stream;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

//임의의 수 스트림 생성*
public class RandomNumberStreamExample {
    public static void main(String[] args) {
        //무한으로 난수 생성 -> infinite stream
//        IntStream ints = new Random().ints();

        //1. limit으로 스트림의 사이즈를 전달해서 그 범위 제한 -> 생성할 수의 갯수를 5개로 제한
        IntStream ints = new Random().ints(5);
        //IntStream ints=new Ranodom().ints().limit(5);
        ints.forEach(System.out::println);

        System.out.println("-".repeat(60));

        DoubleStream doubles = new Random().doubles(10);//10개로 제한
        doubles.forEach(System.out::println);



        //2.특정 범위의 정수 : range(), rangeClose() -> 생성할 수의 값의 범위를 제한
        IntStream intStream1 = IntStream.rangeClosed(1, 10); //-> 끝번호가 포함되어 1~10까지의 숫자 출력
        IntStream intStream2 = IntStream.range(1, 10); // -> 끝번호 포함되지 않아 1~9까지 출력.
        intStream1.forEach(e-> System.out.print(e+" "));//1 2 3 4 5 6 7 8 9 10
        intStream2.forEach(e-> System.out.print(e+" "));//1 2 3 4 5 6 7 8 9

    }
}
