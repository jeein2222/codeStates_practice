package codeStates.thread;

//Thread 클래스를 상속받은 클래스로 스레드 생성 및 실행
public class ThreadClassExample {
    public static void main(String[] args) {
        //Thread 클래스를 상속받은 클래스를 인스턴스화하여 스레드를 생성
        ThreadTask2 thread2 = new ThreadTask2();

        thread2.start();

        for (int i = 0; i < 100; i++) System.out.print("@");

    }
}

//Thread 클래스를 상속받는 클래스 작성
class ThreadTask2 extends Thread{
    public void run(){
        for(int i=0;i<100;i++) System.out.print("#");
    }
}
