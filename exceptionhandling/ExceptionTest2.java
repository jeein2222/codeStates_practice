package codeStates.exceptionhandling;

//예외 처리
public class ExceptionTest2 {
    public static void main(String[] args) {

        try{
            //예외가 발생할 가능성이 있는 코드 삽입
            System.out.println("[소문자 알파벳을 대문자로 출력하는 프로그램]");
            printMyName(null);
            printMyName("abc");

        }
        catch(ArithmeticException e){//instanceOf 연산자를 통해 생성된 예외 클래스의 인스턴스가 조건과 일치하는지 판단
            System.out.println("ArithmeticException 발생");
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException 발생");
            System.out.println("e.getMessage: " + e.getMessage());
            System.out.println("e.toString: " + e.toString());
            e.printStackTrace();
        }
        finally {
            System.out.println("[프로그램 종료]");
        }
    }
    static void printMyName(String str){
        String upperCaseAlphabet = str.toUpperCase();
        System.out.println(upperCaseAlphabet);
    }

    /*
        [소문자 알파벳을 대문자로 출력하는 프로그램]
        NullPointerException 발생
        e.getMessage: null
        e.toString: java.lang.NullPointerException
        [프로그램 종료]
        java.lang.NullPointerException
            at codeStates.ExceptionHandlingExample.printMyName(ExceptionHandlingExample.java:27)
            at codeStates.ExceptionHandlingExample.main(ExceptionHandlingExample.java:9)
     */
}
