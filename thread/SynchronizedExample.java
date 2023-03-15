package codeStates.thread;

public class SynchronizedExample {
    public static void main(String[] args) {
//        Thread thread1 = new Thread(new RunnableTask());
//        Thread thread2 = new SubThread();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) System.out.print("쿵");
            }
        });


        Thread thread2=new Thread(){
            @Override
            public void run(){
                System.out.println("짝");
            }
        };

        System.out.println(thread1.getName());
        System.out.println(thread1.getState());

        thread1.start();
        thread2.start();

        System.out.println(thread1.getState());


        for (int i = 0; i < 10; i++) System.out.print("야");

        System.out.println(thread1.getState());

    }

}

class RunnableTask implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.print("쿵");
    }
}

class SubThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.print("딱");
    }
}
/*
    스레드를 활용하다
    1. 스레드가 수행할 코드를 작성 -> run()
    2. 스레드 생성
    3. 스레드를 실행

    run() 메서드를 작성하는 방법
    1. Runnable 인터페이스를 구현한 클래스에서 run() 구현
    2. Thread 클래스를 상속받은 하위 클래스에서 run()을 오버라이딩 -> Thread 클래스가 이미 Runnable 구현
 */