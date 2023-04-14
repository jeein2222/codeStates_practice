package codeStates.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

//중복순열 부분집합의 걔수를 구하는 경우
/*
    cards = {1,2,3,4} 이중에서 중복순열로 3장을 뽑는 경우의 수
    4^3=64
 */
public class Permutation_with_repetition {

    public ArrayList<Integer[]> pickCardsPermutationWithRepetition(int n) {
        int[] target = {1, 2, 3, 4};
        int[] result = new int[n];
        ArrayList<Integer[]> list = new ArrayList<>();
        permutation_with_repetition(0,n, target,result, list);
        return list;
    }

    public void permutation_with_repetition(int cnt,int r,int[] target ,int[] result,ArrayList<Integer[]> list){
        if(cnt==r){
            int[] newResult = result.clone();
            list.add(Arrays.stream(newResult).boxed().toArray(Integer[]::new));
            return;
        }
        for(int i=0;i<target.length;i++){
            result[cnt] = target[i];
            permutation_with_repetition(cnt + 1, r, target, result, list);
        }

    }



    public static void main(String[] args) {
        Permutation_with_repetition pr = new Permutation_with_repetition();

        ArrayList<Integer[]> list = pr.pickCardsPermutationWithRepetition(3);
        for(int i=0;i<list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
    }


}
