package codeStates.algorithm;

import java.util.Arrays;

//이진 탐색 코드
public class BinarySearchCode {
    public int binarySearch(int[] arr, int target){
        int lt=0;
        int rt=arr.length-1;
        int mid=0;
        while(lt<=rt){
            mid=(lt+rt)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) lt=mid+1;
            else rt=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearchCode bs = new BinarySearchCode();

        int[] array = {2, 4, 3, 6, 7, 8};
        Arrays.sort(array);

        System.out.println(bs.binarySearch(array, 7));

    }
}
