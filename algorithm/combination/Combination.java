package codeStates.algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;

//조합 nCr
public class Combination {

    //반복문
    public static ArrayList<String[]> combinationLoop(){
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        ArrayList<String[]> result = new ArrayList<>();

        //한번 조합한 요소는 다시 조합히자 않음.
        for(int i=0;i<lookup.length;i++){
            for(int j=i+1;j<lookup.length;j++){
                for(int k=j+1;k<lookup.length;k++){
                    String[] input=new String[] {lookup[i], lookup[j], lookup[k]};
                    result.add(input);
                }
            }
        }
        return result;

    }

    //재귀
    void makeCombination(char[] arr, int depth, char[] choosed, int startIdx){
        if(depth ==choosed.length){
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i=startIdx;i<arr.length;i++){
            choosed[depth] = arr[i];
            makeCombination(arr, depth + 1, choosed, i + 1);
        }
    }
    public static void main(String[] args) {
        Combination c = new Combination();
        c.makeCombination(new char[] { 'a','b','c'}, 0, new char[2], 0);
    }
}
