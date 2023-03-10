package codeStates.encapsulation;
/*
    접근 지정자 : 외부로부터 데이터를 보호하고 불필요하게 데이터가 노출되는 것 방지.
    클래스 : public , default
    속성, 메소드, 생성자 : public, protected, default, private
 */

class DefaultClass{//default->같은 패키지에서 접근 가능
    private int a=1;//private -> 선언된 클래스(DefaultClass) 내에서만 접근 가능
    int b=2;//default -> 같은 패키지에 있는 클래스에서 접근 가능
    protected int c=3;//protected -> 같은 패키지 및 다른 패키지의 하위 클래스에서 사용 가능
    public int d=4;//public -> 모든 클래스에서 접근 가능

    private void print1(){
        System.out.println("private: "+a);
        System.out.println("private method");
    }

    void print2(){
        print1(); //같은 클래스 접근 가능
        System.out.println("default method");
    }

    protected void print3(){
        System.out.println("protected method");
    }

    public void print4(){
        System.out.println("public method");
    }
}

public class ModifiersExample {//public -> 모든 클래스에서 엑세스 가능
    public static void main(String[] args) {
        DefaultClass defaultClass = new DefaultClass();
//        defaultClass.a=2; -> 접근 불가
        defaultClass.b=5;
        defaultClass.c=10;
        defaultClass.d=11;
//        defaultClass.print1();->접근 불가
        defaultClass.print2();
        defaultClass.print3();
        defaultClass.print4();
    }
}
