package codeStates.stream;

import java.util.*;
import java.util.stream.Stream;

//컬렉션 스트림 생성
/*
    컬렉션 최상위 클래스인 Collection에 정의된 stream() 메서드를 사용하여 스트림 생성 가능
 */
public class CollectionStreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::print);

        System.out.println();

        Map<String, Integer> map=new HashMap<>();
        map.put("James", 12);
        map.put("Tomas", 10);
        map.put("Amy", 9);
        map.put("Sara", 8);
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        //오름차순
        entrySet.stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.printf("key : " + e.getKey() + " value : " + e.getValue()+"\n"));
        //내림차순
        entrySet.stream()
                .sorted((a,b)-> b.getValue() - a.getValue())
                .forEach(e -> System.out.printf("key : " + e.getKey() + " value : " + e.getValue()+"\n"));
    }
}
