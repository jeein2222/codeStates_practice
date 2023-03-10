package codeStates.thread;

//익명 객체를 사용하여 스레드 생성 및 실행*
public class AnonymousObjectThreadExample {
    public static void main(String[] args) {

        //1.익명 Runnable 구현 객체를 활용하여 스레드 생성
        Thread thread3=new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<100;i++) System.out.print("#");
            }
        });

        thread3.start();

        for(int i=0;i<100;i++) System.out.print("@");

        //2.Thread 익명 객체를 활용한 스레드 생성
        Thread thread4=new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) System.out.print("*");

            }
        };

        thread4.start();


    }
}

