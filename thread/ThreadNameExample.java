package codeStates.thread;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable(){
            public void run(){
                System.out.println("Get Thread Name");
            }
        });

        thread1.start();
        System.out.println("thread1.getName() : " + thread1.getName());

        thread1.setName("My Thread_0");

        System.out.println("thread1.getName() : " + thread1.getName());

    }
    /*
        Get Thread Name
        thread1.getName() : Thread-0
        thread1.getName() : My Thread_0
     */
}
