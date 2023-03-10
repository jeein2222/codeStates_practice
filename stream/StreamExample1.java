package codeStates.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
    Stream은 배열, 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자
    스트림을 사용하면 List, Set, Map 배열 등 다양한 데이터 소스로부터 스트림을 만들 수 있고,
    이를 표준화된 방법으로 다룰 수 있음.*
 */
public class StreamExample1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //기존 방법
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            int num = it.next();
            System.out.print(num);//12345
        }

        System.out.println();

        //stream을 이용한 반복 처리
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::print);//12345
        /*
            스트림을 사용하면 기존의 방법보다 간결하게 코드를 작성할 수 있으며,
            데이터 소스가 무엇이냐에 관계없이 통일된 방식으로 데이터를 가공/처리할 수 있음.

            스트림을 사용하면 '무엇'에 집중하여 코드를 작성하는 코드 작성 방법론인 선언형 프로그래밍이 가능하다.
            즉, 내부의 동작 원리를 몰라도 어떤 코드가 어떤 역할을 하는지 직관적으로 파악 가능.
            (스트림은 내부 반복자로, 데이터 처리 코드만 컬렉션 내부로 주입해줘서 그 안에서 모든 데이터 처리가 이뤄지도록 함)
         */
    }
}
