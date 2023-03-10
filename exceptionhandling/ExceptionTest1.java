package codeStates.exceptionhandling;

public class ExceptionTest1 {
    public static void main(String[] args) {
        try{
            Exception intendedException = new Exception("의도된 예외");
            throw intendedException;
        }catch(Exception e){
            System.out.println("고의로 예외 발생시키기 성공!");
        }

    }
}
