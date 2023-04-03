package codeStates.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

//순열이 모든 경우의 수를 나열하고자 할때
public class Permutation {
    //반복문으로 구현
    public static ArrayList<String[]> permutaionLoop(){
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        ArrayList<String[]> result = new ArrayList<>();

        for(int i=0;i<lookup.length;i++){
            for(int j=0;j<lookup.length;j++){
                for(int k=0;k<lookup.length;k++){
                    if(i==j || j==k || k==j) continue;//중복된 요소는 제거
                    String[] input = new String[]{lookup[i], lookup[j], lookup[k]};
                    result.add(input);
                }
            }
        }
        return result;
    }

    //재귀로 구현
    public void permutation(ArrayList<Integer[] > resultList, ArrayList<Integer> itemList, int[] result, int depth, int n,int r){
        if(depth==r){
            resultList.add(Arrays.stream(result.clone()).boxed().toArray(Integer[]::new));
            return;
        }
        for(int i=0;i<n-depth;i++){
            result[depth] = itemList.remove(i);
            permutation(resultList, itemList, result, depth + 1,n,r);
            itemList.add(i, result[depth]);
        }

    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer[]> resultList = new ArrayList<>();
        int[] result = new int[3];
        p.permutation(resultList, arr, result, 0, 4, 3);
        for(int i=0;i<resultList.size();i++){
            System.out.println(Arrays.toString(resultList.get(i)));
        }
    }
}
