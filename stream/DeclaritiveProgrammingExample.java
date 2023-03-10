package codeStates.stream;

import java.util.List;
import java.util.stream.Stream;

//명령형 프로그래밍 vs 선언형 프로그래밍*
public class DeclaritiveProgrammingExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 4, 5, 6, 8);

        //명령형 프로그래밍 : 직접 모든 요소를 순회하며 작업 수행
        int sum=0;
        for(int number:numbers){
            if(number > 4 && (number%2==0)) sum += number;
        }

        System.out.println("명령형 프로그래밍을 사용한 합계 : "+sum);

        //선언형 프로그래밍 : 내부가 어떻게 동작하는 지 몰라도 어떤 코드가 어떤 역할을 하는지 직관적으로 파악 가능
        System.out.println("선언형 프로그래밍을 사용한 합계 : " +
                        numbers.stream()
                        .filter(number->number>4 && (number%2==0))
                        .mapToInt(number->number).sum()
        );

    }
}
