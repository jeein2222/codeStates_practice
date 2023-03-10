package codeStates.thread;

//스레드의 상태 변환
public class ThreadStateExample2 {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();

        sumThread.setTo(10);

        sumThread.start();

        //메인 스레드가 sumThread의 작업이 끝날때 까지 기다림.
        try{ sumThread.join();} catch (Exception e){}

        System.out.println(String.format("1부터 %d까지의 합 : %d",sumThread.getTo(),sumThread.getSum()));
    }
}

class SumThread extends Thread{
    private long sum;
    private int to;

    public long getSum() {
        return this.sum;
    }

    public int getTo() {
        return this.to;
    }

    public void setTo(final int to) {
        this.to = to;
    }

    public void run(){
        for (int i = 1; i <= to; i++) sum += i;
    }
}
