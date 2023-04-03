package codeStates.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sol6_permutation2 {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        //사용 가능한 재료만 넣을 변수 선언
        ArrayList<Integer> freshArr = new ArrayList<>();

        //stuffArr를 순회하며 사용 가능한 재료만 freshArr 리스트에 추가
        for(int i=0;i<stuffArr.length;i++){
            String str = String.valueOf(stuffArr[i]);
            //0이 들어간 개수만큼 element에 추가
            int[] element = str.chars().filter(c -> c == '0').toArray();
            //element 배열의 숫자가 2이하인 경우
            if(element.length<=2){
                freshArr.add(stuffArr[i]);
            }
        }
        //재료가 들어간 List를 오름차순으로 정렬함.
        Collections.sort(freshArr);

        //사용할 수 있는 재료가 없거나, 재료의 양보다 사용해야 할 갯수가 더 많은 경우
        if(freshArr.size()==0 || freshArr.size()<choiceNum) return null;

        //결과를 담을 리스트 선언
        ArrayList<Integer[]> result = new ArrayList<>();

        //해당 재료의 사용 여부를 확인할 배열 선언
        boolean[] visited = new boolean[freshArr.size()];

        //순열 메소드를 사용하여 모든 경우의 수를 구하고, 해당 자료를 반환
        return permutation(choiceNum, new Integer[]{}, result, freshArr, visited, 0);
    }

    public ArrayList<Integer[]> permutation(int choiceNum, Integer[] bucket,ArrayList<Integer[]> result, ArrayList<Integer> freshArr, boolean[] visited,int depth){
        if(depth==choiceNum){
            result.add(bucket);
            return result;
        }
        for(int i=0;i<freshArr.size();i++){
            if(!visited[i]){
                visited[i] = true;
                Integer[] concatArray = Arrays.copyOf(bucket, bucket.length + 1);
                concatArray[concatArray.length - 1] = freshArr.get(i);

                result = permutation(choiceNum, concatArray, result, freshArr, visited, depth + 1);
                visited[i]=false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sol6_permutation2 p = new Sol6_permutation2();
        ArrayList<Integer[]> list=p.newChickenRecipe(new int[] {11, 1, 10, 11111, 10000}, 4);

        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                System.out.println(Arrays.toString(list.get(i)));
            }
        }
    }
}
