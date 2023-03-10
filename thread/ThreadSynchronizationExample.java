package codeStates.thread;

//스레드 동기화 예제
public class ThreadSynchronizationExample {
    public static void main(String[] args) {
        Runnable threadTask3 = new ThreadTask3();
        Thread thread3_1 = new Thread(threadTask3);
        Thread thread3_2 = new Thread(threadTask3);

        thread3_1.setName("김코딩");
        thread3_2.setName("박자바");

        thread3_1.start();
        thread3_2.start();
    }
}

class Account{
    private int balance = 1000;

    public int getBalance(){
        return balance;
    }
    //동기화 처리 1) 메서드 전체를 임계 영역으로 지정
//    public synchronized boolean withdraw(int money){
//        if(balance>=money){
//            try{ Thread.sleep(1000);} catch(Exception error){}
//            balance -= money;
//            return true;
//        }
//        return false;
//    }

    //동기화 처리 2) 특정한 영역을 임계 영역으로 지정하기
    public boolean withdraw(int money){
        synchronized (this){
            if(balance>=money){
                try{ Thread.sleep(1000);} catch(Exception error){}
                balance -= money;
                return true;
            }
        }
        return false;
    }
}

class ThreadTask3 implements Runnable {
    Account account = new Account();

    @Override
    public void run() {
        while(account.getBalance()>0){
            //100~300원의 인출금을 랜덤으로 정함.
            int money = (int) (Math.random() * 3 + 1) * 100;

            //withdraw를 실행시키는 동시에 인출성공 여부를 변수에 할당
            boolean denied = !account.withdraw(money);

            //인출 결과 확인
            System.out.println(String.format("Withdraw %d원 By %s. Balancce : %d %s",
                    money, Thread.currentThread().getName(), account.getBalance(),denied));
        }
    }
}