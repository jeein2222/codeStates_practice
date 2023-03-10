package codeStates.inheritance;

class SuperClass{
    int count=20;
    SuperClass(){
        System.out.println("상위 클래스 생성자");
    }
}

class SubClass extends SuperClass{
    int count=15;

    SubClass(){
        super();//상위 클래스의 생성자 호출, 반드시 첫 줄에 와야
        System.out.println("하위 클래스 생성자");

    }

    void calNum(){
        //super->상위 클래스의 인스턴스 필드와 하위 클래스의 인스턴스 필드의 이름이 같아 구분하기 위한 키워드
        System.out.println("count = "+count);//자신이 속한 인스턴스 객체의 멤버를 먼제 참조
        System.out.println("this.count = "+this.count);
        System.out.println("super.count = "+super.count);//부모 객체의 멤버값 참조
    }
}


public class SuperExample {
    public static void main(String[] args) {

    }
}
