package codeStates.algorithm;

import java.util.Arrays;


//짐 나르기
public class Sol1_Greedy {
    public int movingStuff(int[] stuff, int limit) {
        //stuff를 가벼운 것부터 정렬
        stuff = Arrays.stream(stuff).sorted().toArray();

        //쌍으로 묶이는 짐의 개수
        int count = 0;

        //가장 가벼운 짐부터 무거운 짐으로 이동할 index
        int leftIdx=0;

        //가장 무거운 집부터 가벼운 짐으로 이동할 index
        int rightIdx=stuff.length-1;

        while(leftIdx<rightIdx){
            if(stuff[leftIdx]+stuff[rightIdx]<=limit){
                count++;
                leftIdx++;
                rightIdx--;
            }else{
                rightIdx--;
            }
        }

        return stuff.length-count;

    }

    public static void main(String[] args) {
        Sol1_Greedy s = new Sol1_Greedy();
        System.out.println(s.movingStuff(new int[]{70, 50, 80, 50}, 100));
    }
}
