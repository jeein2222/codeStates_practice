package codeStates.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//새로운 치킨 소스 레시피
public class Sol6_permutation {

    public int[] countZeros(int[] stuffArr){//재료의 0의 개수 구하기
        int[] cntZero = new int[stuffArr.length];

        for(int i=0;i<stuffArr.length;i++){
            while(stuffArr[i]>0){
                if(stuffArr[i]%10==0) cntZero[i]+=1;
                stuffArr[i] /= 10;
            }
        }
        return cntZero;
    }
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        //결과를 담을 배열
        ArrayList<Integer[]> list;

        //재료별 의 0의 개수 구하기
        int[] cntZero=countZeros(stuffArr.clone());

        //사용 불가능한 재료의 개수 구하기
        int cnt=0;
        ArrayList<Integer> unusableIdx = new ArrayList<>();
        for(int i=0;i<cntZero.length;i++){
            if(cntZero[i]>=3){
                unusableIdx.add(i);
                cnt++;
            }
        }


        //사용 가능한 재료만 따로 저장
        ArrayList<Integer> usableStuff = new ArrayList<>();
        for(int i=0;i<stuffArr.length;i++){
            if(!unusableIdx.contains(i)) {
                usableStuff.add(stuffArr[i]);
            }
        }


        if(cnt==stuffArr.length || usableStuff.size()<choiceNum) return null;//주어진 재료를 모두 사용할 수 없거나 사용 가능한 재료의 개수 < choiceNum -> null
        else{
            list= new ArrayList<>();
            int[] result = new int[choiceNum];
            usableStuff.sort(Comparator.naturalOrder());
            permutation(list, usableStuff, result, 0,usableStuff.size(), choiceNum);

        }

        return list;

    }

    public void permutation(ArrayList<Integer[]> resultList, ArrayList<Integer> itemList, int[] result, int depth, int n,int r){
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
        Sol6_permutation p = new Sol6_permutation();
        ArrayList<Integer[]> list=p.newChickenRecipe(new int[] {11, 1, 10, 1111111111, 10000}, 4);

        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                System.out.println(Arrays.toString(list.get(i)));
            }
        }

    }



}
