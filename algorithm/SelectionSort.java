package codeStates.algorithm;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] arr){
        //주어진 배열을 Selection Sort로 오름차순 정렬함.
        for (int i = 0; i < arr.length - 1; i++) {
            //배열의 0번째 인덱스부터 마지막 인덱스전까지 반복
            //현재 값 위치에 가장 작은 값 넣음.
            int min = i;
            //현재 인덱스를 최소값의 인덱스르 나타내는 변수에 할당
            for(int j=i+1;j<arr.length;j++){
                //현재 i에 +1을 j로 반복문을 초기화하고 i 이후의 배열요소와 비교하는 반복문 구성
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            //반복문이 끝났을 때
            //min에는 최소값의 인덱스가 들어 있음.
            //i값과 최소값을 바꿔서 할당
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min]=tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        System.out.println(Arrays.toString(s.selectionSort(new int[] {3,5,4,1,6})));
    }
}
