package codeStates.datastructure;

import java.lang.reflect.Array;
import java.util.*;

//박스 포장_Queue
public class Sol2 {
    public int paveBox(Integer[] boxes) {
        List<Integer> listQueue = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0;i<boxes.length;i++){
            listQueue.add(boxes[i]);
        }

        while(!listQueue.isEmpty()) {
            int maxIndex = findMaxIndex(listQueue);

            if (maxIndex == -1) {
                answerList.add(listQueue.size());
                listQueue.clear();
            } else {
                answerList.add(maxIndex);//앞에 요소들의 개수
                listQueue = listQueue.subList(maxIndex, listQueue.size());//max 숫자부터 끝까지 자르기
            }
        }
        return Collections.max(answerList);

    }

    public int findMaxIndex(List<Integer> list){
        int maxIndex=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(0)<list.get(i)){
                maxIndex=i;
                break;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Sol2 s = new Sol2();

        Integer[] boxes = new Integer[]{5, 1, 8,3,2,1};
        int output = s.paveBox(boxes);
        System.out.println(output); // 4



    }
}
