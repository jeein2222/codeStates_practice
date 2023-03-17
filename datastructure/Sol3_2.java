package codeStates.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//프린터
public class Sol3_2 {
    /*
        buff:2 cap:10 docu:7 4 5 6
        1초 후 queue.add(7)
        2초 후 7 한칸 이동 7+4>10 queue
        3초 후 queue.poll() -> 7 print , queue.add(4)
        4초 후 4한 칸 이동 4+5<10 queue.add(5)
        5초 후 queue.poll() -> 4 print, 5한칸 이동, 5+6>10
        6초 후 queue.poll() -> 5 print, queue.add(6)
        7초 후 6한 칸 이동
        8초 후 queue.poll() -> 6 print -> 끈
     */
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        //결과를 담을 변수를 선언, 초기화
        int count=0;

        //인쇄 환경을 담을 큐 선언 큐는 추상 인터페이스, LinkedList, 우선순위큐로 구현 가능
        Queue<Integer> q = new LinkedList<>();

        //선언한 큐를 0으로 채워 줌.
        for (int i = 0; i < bufferSize; i++) q.add(0);

        //첫 시작은 초기값을 빼주고, 0번 문서를 넣어준다.
        q.poll();
        q.add(documents[0]);
        documents = Arrays.copyOfRange(documents, 1, documents.length);
        count++;

        //반복 시작 ( 더 이상 문서가 없을 경우 && 대기열이 존재하지 않는 경우 멈춰야 함)
        while(documents.length !=0 || q.stream().reduce(0,Integer::sum)!=0){
            if(documents.length!=0){//대기중인 문서가 남은 경우
                int sum = q.stream().reduce(0, Integer::sum)+documents[0];
                if(sum>capacities){//작업 중인 문서와, 남은 문서 중 가장 처음 문서의 크기가 capacities보다 큰 경우
                    q.poll();
                    sum=q.stream().reduce(0, Integer::sum)+documents[0];
                    if(sum<=capacities){//문서가 제거되고, 남은 대기열의 첫번째 문서를 포함했을 때 수용이 가능하다면,
                        q.add(documents[0]);
                        documents = Arrays.copyOfRange(documents, 1, documents.length);
                        count++;
                    }else{ //문서가 제거되고, 남은 대기열의 첫번째 문서를 포함했을 때 수용이 불가능하다면,
                        q.add(0);
                        count++;
                    }
                }else{//작업 중인 문서와, 남은 문서 중 가장 처음 문서의 크기가 capacities보다 작은 경우
                    q.poll();
                    q.add(documents[0]);
                    documents = Arrays.copyOfRange(documents, 1, documents.length);
                    count++;
                }
            }
            else{//대기중인 문서가 없는 경우
                q.poll();
                q.add(0);
                count++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        Sol3_2 s = new Sol3_2();
        System.out.println(s.queuePrinter(2, 10, new int[] {7,4,5,6}));
    }
}
