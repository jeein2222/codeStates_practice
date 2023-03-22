package codeStates.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Sol1 {
    public int movingStuff(int[] stuff, int limit) {
        //stuff 배열 정렬하기(오름차순으로)
        int[] newStuff = Arrays.stream(stuff).sorted().toArray();

        //최대 2개를 묶을 수 있는 횟수
        int count=0;

        //가장 무거운 짐
        int largeIdx=newStuff.length-1;

        //가장 가벼운 짐
        int smallIdx=0;

        while(largeIdx>smallIdx){
            if(newStuff[smallIdx]+newStuff[largeIdx]<=limit){
                count++;
                smallIdx++;
                largeIdx--;
            }else{
                largeIdx--;
            }
        }

        return newStuff.length-count;
    }

    public static void main(String[] args) {
        Sol1 s = new Sol1();
        System.out.println(s.movingStuff(new int[]{70, 50, 80, 50}, 100));
    }
}
