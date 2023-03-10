package codeStates.thread;

//스레드의 상태 변환
public class ThreadStateExample {
    public static void main(String[] args) {
        Thread thread1=new Thread(){
            public void run(){
                try{
                    while(true) Thread.sleep(100);
                }catch (Exception e){}
                System.out.println("Woke Up!!!");
            }
        };

        System.out.println("thread1.getState() = " + thread1.getState());//아직 시작되지 않은 스레드의 상태

        thread1.start();

        System.out.println("thread1.getState() = " + thread1.getState());

        while(true){
            if(thread1.getState() == Thread.State.TIMED_WAITING){//지정된 대기 시간까지 다른 스레드가 작업을 수행하기를 기다림.
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        thread1.interrupt();

        while(true){
            if(thread1.getState()==Thread.State.RUNNABLE){//실행 중인 스레드의 상태
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        while(true){
            if(thread1.getState()==Thread.State.TERMINATED){//종료된 스레드의 상태
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

    }
}
