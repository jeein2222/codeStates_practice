package codeStates.inheritance;

/*
    정적 내부 클래스
 */

class Outer2{
    private int num=1;
    private static int sNum=2;

    void getPrint(){
        System.out.println("Outer 인스턴스 메서드");
    }

    static void getPrintStatic(){
        System.out.println("Outer 정적 메서드");
    }

    static class StaticInClass{
        int inNum=0;
        static int sInNum=5;
        void test(){
//            System.out.println("Outer num= "+num);->non-static
            System.out.println("Outer sNum= "+sNum);
            System.out.println("In Num= "+inNum);
            System.out.println("In sNum= "+sInNum);

//            getPrint();->non-static
            getPrintStatic();
        }

    }
}

public class StaticNestedClassExample {
    public static void main(String[] args) {
        Outer2.StaticInClass s = new Outer2.StaticInClass();
        s.test();
    }
}
