package codeStates.innerclass;

/*
    지역 내부 클래스
 */
class Outer3 {//외부 클래스
    private int num1=1; //외부 클래스 인스턴스 변수
    private static int sNum=2; //외부 클래스 정적 변수

    void test(){
        int num2=5;
        class LocalInClass{//지역 내부 클래스
            private int inNum=1;
//            private static int sInNum=2; -> 선언 불가
            void getPrint(){
                System.out.println("inNum= "+inNum);
                System.out.println("outNum= "+num1);
                System.out.println("methodNum= "+num2);
                System.out.println("outSnum= "+sNum);
            }

        }
        LocalInClass localInClass=new LocalInClass();
        localInClass.getPrint();
    }


}

public class LocalInnerClassExample{
    public static void main(String[] args) {
        Outer3 outer=new Outer3();
        outer.test();
    }
}


