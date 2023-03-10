package codeStates;
/*
    인스턴스 내부 클래스
 */
class Outer1{
    private int num=1; //외부 클래스 인스턴스 변수
    private static int sNum=2; //외부 클래스 정적 변수
    private InClass inClass;

    public Outer1(){
        inClass=new InClass();
    }

    class InClass{//인스턴스 내부 클래스
        int inNum=10;//내부 클래스의 인스턴스 변수
        //static int sInNum=5;->선언 불가
        void test(){
            //외부 클래스의 인스턴스 변수와 정적 변수에 접근 가능
            System.out.println("Outer num= "+num);
            System.out.println("Outer sNum= "+sNum);
            System.out.println("In Num= "+inNum);
        }
    }

    public void testClass(){
        inClass.test();
    }
}

public class MemberInnerClassExample {
    public static void main(String[] args) {
        Outer1 outer=new Outer1();
        outer.testClass();

    }
}
