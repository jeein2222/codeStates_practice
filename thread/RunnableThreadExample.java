package codeStates.thread;

//Runnable 인터페이스를 구현한 클래스를 사용하여 스레드 생성 및 실행*
public class RunnableThreadExample {
    public static void main(String[] args) {
        //Runnable 구현 객체를 인자로 전달하면서 Thread 클래스를 인스턴스화 하여 스레드 생성
        Thread thread1 = new Thread(new ThreadTask1());

        thread1.start();

        //반복문 추가
        for (int i = 0; i < 100; i++)
            System.out.print("@");
    }
}

class ThreadTask1 implements Runnable{
    public void run(){
        for(int i=0;i<100;i++)
            System.out.print("#");
    }
}
