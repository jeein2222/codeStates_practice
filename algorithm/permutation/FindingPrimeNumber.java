package codeStates.algorithm.permutation;

import java.util.ArrayList;
import java.util.Arrays;

/*
    한자리 숫자가 적힌 종잇조각이 흩어져있다.
    흩어진 종잇조각을 붙여 소수를 몇 개 만들 수 있는지 알아내어라.
 */
public class FindingPrimeNumber {

    public void permutation(ArrayList<Integer[] > resultList, ArrayList<Integer> itemList, int[] result, int depth, int n,int r){
        if(depth==r){
            int[] newResult = result.clone();
            int num=0;
            if(newResult.length>1){
                num = newResult[0];
            }else{
                for(int i=0;i<newResult.length;i++){
                    num+=newResult[i]*Math.pow(10,(newResult.length-i-1));
                }
            }

            if(countDivisors(num)==2){
                resultList.add(Arrays.stream(newResult).boxed().toArray(Integer[]::new));
            }

            return;
        }
        for(int i=0;i<n-depth;i++){
            result[depth] = itemList.remove(i);
            permutation(resultList, itemList, result, depth + 1,n,r);
            itemList.add(i, result[depth]);
        }
    }

    public int countDivisors(int n){
        int count=0;
        for(int i=1;i*i<=n;i++){
            if(i*i==n) count++;
            else if(n%i==0) count+=2;
        }
        return count;
    }

    public static void main(String[] args) {
        FindingPrimeNumber fpn = new FindingPrimeNumber();
        ArrayList<Integer[]> resultList = new ArrayList<>();
        ArrayList<Integer> itemList = new ArrayList<>(Arrays.asList(1, 2, 3));

        for (int i = 1; i <= itemList.toArray().length; i++) {
            int[] result = new int[i];
            fpn.permutation(resultList, itemList, result, 0, itemList.size(), result.length);
        }

        for(int i=0;i<resultList.size();i++){
            System.out.println(Arrays.toString(resultList.get(i)));
        }

        System.out.println(resultList.size());


    }
}
