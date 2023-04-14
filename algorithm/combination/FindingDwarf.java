package codeStates.algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;

/*
    아홉난쟁이의 각각의 키가 주어질 때, 일곱 난쟁이를 찾는 방법은 몇가지?
    조합을 이용해 9명 중 7명을 뽑아 키의 합을 따졌을 때 100이 되는 경우의 수
 */
public class FindingDwarf {
    public void combination(ArrayList<Integer[]> resultList, ArrayList<Integer> itemList, int[] result, int depth, int startIdx) {
        if (depth == result.length) {
            resultList.add(Arrays.stream(result.clone()).boxed().toArray(Integer[]::new));
            return;
        }
        for (int i = startIdx; i < itemList.size(); i++) {
            result[depth] = itemList.get(i);
            combination(resultList, itemList, result, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        FindingDwarf fd = new FindingDwarf();
        ArrayList<Integer[]> resultList = new ArrayList<>();
        ArrayList<Integer> itemList = new ArrayList<>(Arrays.asList(10, 20, 15, 12, 13, 11, 19, 8, 6));
        int[] result = new int[7];
        fd.combination(resultList, itemList, result,0,0);
        int cnt=0;
        for(int i=0;i<resultList.size();i++){
            if(Arrays.stream(resultList.get(i)).mapToInt(a->a.intValue()).sum()==100)
                cnt++;
        }

        System.out.println(cnt);

    }
}
