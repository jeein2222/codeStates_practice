package codeStates.recursion;


import java.util.Arrays;

public class Sol1 {
    // 자연수로 이루어진 리스트(배열)를 입력받고, 리스트의 합을 리턴하는 메서드 `arrSum` 을 작성하세요.

    //반복문 버전
    public int arrSum1(int[] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //재귀 버전
    /*
        arrSum([])=0;
        arrSum([5])=5+arrSum([]);
        arrSum([4,5])=4+arrSum([5])+arrSum([]);
        arrSum([3,4,5])=3+arrSum([4])+arrSum([5])+arrSum([]);
     */
    public int arrSum2(int[] arr){
        if(arr.length==0) return 0;
        int[] tail = Arrays.copyOfRange(arr, 1, arr.length);
        return arr[0] + arrSum2(tail);
    }

    public static void main(String[] args) {
        Sol1 s = new Sol1();
        System.out.println(s.arrSum1(new int[] {1,2,3,4,5}));
        System.out.println(s.arrSum2(new int[] {1,2,3,4,5}));
    }
}
