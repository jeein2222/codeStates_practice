package codeStates.thread;

//스레드 인스턴스의 주소값 얻기*
public class CurrentThreadExample {
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());//Thread-0
            }
        });

        thread1.start();

        System.out.println(Thread.currentThread().getName());//main
    }
    /*
        main
        Thread-0
     */
}
