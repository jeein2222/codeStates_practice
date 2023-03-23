package codeStates.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//블랙잭은 지겨워
public class Sol7_combination {
    public int countDivisors(int n){
        int count=0;
        for(int i=1;i*i<=n;i++){
            if(i*i==n) count++;
            else if(n%i==0) count+=2;
        }
        return count;
    }

    public int boringBlackjack(int[] cards) {
        ArrayList<Integer> sums = new ArrayList<>();
        int cnt=0;
        makeCombination(cards, sums,0, new int[3], 0);

        for(int i=0;i<sums.size();i++){
            if(countDivisors(sums.get(i))==2){
                cnt++;
            }
        }
        return cnt;
    }
    void makeCombination(int[] arr, ArrayList<Integer> sums, int depth, int[] choosed, int startIdx){
        if(depth ==choosed.length){
            sums.add(Arrays.stream(choosed.clone()).sum());
            return;
        }
        for(int i=startIdx;i<arr.length;i++){
            choosed[depth] = arr[i];
            makeCombination(arr, sums,depth + 1, choosed, i + 1);
        }
    }
    public static void main(String[] args) {
        Sol7_combination c = new Sol7_combination();
        System.out.println(c.boringBlackjack(new int[]{1, 2, 3, 4}));
    }
}
