package codeStates.lambda;

import java.util.function.IntBinaryOperator;

/*
    람다식 : 함수형 프로그래밍 기법을 지원하는 자바의 문법 요소(메서드를 하나의 식으로 표현할 수 있음)
    람다식 -> 익명 객체(익명 클래스를 통해 만들 수 있는데, 익명 클래스란 객체의 선언과 생성을 동시에 하여
    오직 하나의 객체를 생성하고 단 한번만 사용되는 일회용 클래스)


 */
public class LambdaExample1 {
    public static void main(String[] args) {
        //함수형 인터페이스로 만든 익명 구현 객체
        SumFunction s = (n1, n2) -> n1 + n2;
        System.out.println(s.sum(2,3));//5

        //자바에서 기본적으로 제공하는 함수형 메서드
        IntBinaryOperator sum = (n1, n2) -> n1 + n2;
        System.out.println(sum.applyAsInt(2, 3));//5

        //메서드 레퍼런스(참조) : 람다식에서 불필요한 매개변수를 제거할 때 주로 사용
        //클래스 이름 :: 메서드 이름 (정적, 인스턴스 메서드를 참조할 수 있고, 생성자 참조도 가능)
        IntBinaryOperator operator;

        //정적 메소드
        operator=Calculator::staticMethod;
        System.out.println("정적 메서드 결과 : " + operator.applyAsInt(2, 3));//5

        //인스턴스 메서드
        Calculator c = new Calculator();
        operator = c::instanceMethod;
        System.out.println("인스턴스 메서드 결과 : " + operator.applyAsInt(2, 3));//6



    }

    @FunctionalInterface
    interface SumFunction{
        int sum(int num1, int num2);
    }
}

class Calculator{
    public static int staticMethod(int x, int y) {
        return x+y;
    }
    public int instanceMethod(int x, int y){
        return x * y;
    }
}