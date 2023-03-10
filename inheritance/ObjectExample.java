package codeStates;

class ParentEx{//컴파일러가 extends Object 자동 추가
    /*
        Object 클래스의 멤버들을 자동으로 상속받아 사용할 수 있다.
        toString() : 객체 정보를 문자열로 출력
        equals(Object obj) : 등가 비교 연산과 동일하게 스택 메모리 값 비교
        hashCode() : 객체의 위치 정보 관련
        wait() : 현재 쓰레드 일시 정지
        notify() : 일시정지 중인 쓰레드 재동작
     */

    @Override
    public String toString() {
        return "부모 클래스";
    }
}

class ChildEx extends ParentEx{
    @Override
    public String toString() {
        return "자식 클래스";
    }
}


public class ObjectExample {
    public static void main(String[] args) {
        ParentEx p = new ParentEx();
        ChildEx c = new ChildEx();

        System.out.println(p.toString());
        System.out.println(c.toString());
    }
}
