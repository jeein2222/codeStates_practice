package codeStates.datastructure;

import java.util.*;

public class Sol2_2 {
    // ArrayList를 활용한 풀이법
    public int paveBox1(Integer[] boxes) {
        ArrayList<Integer> answer = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(boxes));

        while (arrayList.size() > 0) { // 만약 찾았다면, 해당 key를 answer에 넣고, ArrayList에서 그만큼 제외합니다.
            for(int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) > arrayList.get(0)) {
                    answer.add(i);
                    arrayList = arrayList.subList(i , arrayList.size());
                    break;
                }
                // 만약 찾지 못했다면 answer에 arrayList 크기를 넣은 후, arrayList 내부의 요소를 전부 삭제합니다.
                if(i == arrayList.size() - 1) {
                    answer.add(arrayList.size());
                    arrayList.clear();
                }
            }
        }
        return answer.stream().max(Integer::compare).orElse(-1);
    }

    // Queue를 활용한 풀이법
     public int paveBox2(Integer[] boxes) {
       Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxes));

       //첫 사람 선언, 할당
       Integer first = queue.poll();
       // 결과를 담을 변수, 초기값 1
       int result = 1;
       // 앞으로 비교할 인원수, 초기값 1
       int count = 1;

       // 큐가 빌 때까지 순회
       while(queue.peek() != null) {
         // 비교할 짐 할당
         Integer compare = queue.poll();
         // 비교할 짐이 더 크다면(함께 나갈 수 없는 경우)
         if(first < compare) {
           // 결과와 현재 나갈 수 있는 수중 큰 수를 할당
           result = Math.max(result,count);
           // 카운트 초기화
           count = 1;
           // 이번에 나갈 사람을 first에 할당(나갈 사람은 벌써 compare에 poll()을 사용해 큐에서 비어있는 상황)
           first = compare;
         } else {
           // 비교할 짐이 더 작다면(함께 나갈 수 있는 경우)
           count++;
           // 마지막까지 다 순회했는데도 더 큰 짐이 없는 경우
           if(queue.isEmpty()) {
             // 현재까지 나갈 수 있는 짐의 크기와, 앞서서 비교한 값중 큰 값을 할당
             result = Math.max(result,count);
           }
         }
       }
       //결과 반환
       return result;
     }
}
