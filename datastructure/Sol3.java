package codeStates.datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//프린터
public class Sol3 {
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bufferSize; i++) q.add(0);
        q.poll();
        q.add(documents[0]);
        int time=1;

        documents = Arrays.copyOfRange(documents, 1, documents.length);


        //documents도 비어었고, 큐도 비어있을 경우 멈춰야 함.
        while(documents.length!=0 || q.stream().reduce(0,Integer::sum )!=0){
            if(documents.length!=0) {//대기 중인 문서가 남은 경우
                int sum = q.stream().reduce(0, Integer::sum) + documents[0];
                if(sum>capacities){
                    q.poll();
                    sum=q.stream().reduce(0, Integer::sum) + documents[0];
                    if(sum<=capacities){
                        q.add(documents[0]);
                        documents = Arrays.copyOfRange(documents, 1, documents.length);
                        time++;
                    }else{
                        q.add(0);
                        time++;
                    }
                }else{
                    q.poll();
                    q.add(documents[0]);
                    documents = Arrays.copyOfRange(documents, 1, documents.length);
                    time++;
                }
            }else{
                q.poll();
                q.add(0);
                time++;
            }
        }

        return time;
    }
    public static void main(String[] args) {
        Sol3 s = new Sol3();
        System.out.println(s.queuePrinter(2, 10, new int[] {7,4,5,6}));
    }
}
