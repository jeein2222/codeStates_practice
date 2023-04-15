package codeStates.array;

import java.util.Arrays;
import java.util.Comparator;

//다차원 배열
public class multiDimensionalArraySort {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {4, 5}, {3, 4}};
        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
        //하나의 배열로 풀때..
        int[] result = Arrays.stream(arr).flatMapToInt(a -> Arrays.stream(a)).toArray();
        System.out.println(Arrays.toString(result));//[1, 2, 3, 4, 4, 5]

        //두 번째 요소까지 고려할 때...
        int[][] arr2 = {{1, 2}, {4, 5}, {3, 4}, {3, 2}};
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
    }

}
