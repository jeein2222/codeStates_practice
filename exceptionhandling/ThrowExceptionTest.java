package codeStates.exceptionhandling;

public class ThrowExceptionTest {
    public static void main(String[] args) {
        try{
            throwException();
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());//java.lang.Strings
        }
    }
    static void throwException() throws ClassNotFoundException, NullPointerException{
        //해당 예외를 발생한 메서드 안에서 처리하지 않고 메서드를 호출한 곳으로 떠넘김.
        Class.forName("java.lang.Strings");
    }
}
