package codeStates.recursion;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

//재귀함수 연습문제
public class RecursivePractice {
    public int sumTo(int num){
        if(num==0) return 0;
        return num+sumTo(num-1);
    }
    public boolean isOdd(int num){
        if(num==0) return false;
        else if(num==1) return true;
        else if(num>0) return isOdd(num-2);
        else return isOdd(-num);
    }

    public int factorial(int num){
        //TODO..
        if(num<=1) return 1;
        return num*factorial(num-1);
    }

    public int fibonacci(int num){
        //TODO..
        if(num==0) return 0;
        if(num==1) return 1;
        return fibonacci(num-1)+fibonacci(num-2);
    }

    public int arrSum(int[] arr){
        //TODO..
        if(arr.length == 0) return 0;
        return arr[0]+arrSum(Arrays.copyOfRange(arr,1,arr.length));
    }

    public int arrProduct(int[] arr){
        // TODO:
        if(arr.length==0) return 1;
        return arr[0]*arrProduct(Arrays.copyOfRange(arr,1,arr.length));
    }

    public int arrLength(int[] arr){
        // TODO:
        if(arr.length==0) return 0;
        return 1+arrLength(Arrays.copyOfRange(arr,1,arr.length));
    }

    /*
        {1,2,3,4,5}
        num=2
        drop(1,{2,3,4,5}) -> num=1
                            drop(0,{3,4,5}) ->
     */

    public int[] drop(int num, int[] arr){
        // TODO:
        if(arr.length==0 || num==0) return arr;
        else if(arr.length<num) return new int[] {};
        return drop(num-1,Arrays.copyOfRange(arr,1,arr.length));
    }

    /*
        1 2 3 4 5
        num=3
        1
     */
    public int[] take(int num, int[] arr){
        if(num==0 || arr.length==0) return new int[] {};

        int[] head = Arrays.copyOfRange(arr, 0, 1);
        int[] tail = take(num - 1, Arrays.copyOfRange(arr, 1, arr.length));

        int[] result = new int[head.length + tail.length];

        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail, 0, result, head.length, tail.length);

        return result;
    }

    public boolean and(boolean[] arr){
        // TODO:
        if(arr.length==0) return true;
        return arr[0] & and(Arrays.copyOfRange(arr,1,arr.length));
    }

    public boolean or(boolean[] arr){
        // TODO:
        if(arr.length==0) return false;
        return arr[0] || or(Arrays.copyOfRange(arr,1,arr.length));
    }

    public int[] reverseArr(int[] arr){
        if(arr.length==0) return new int[] {};

        int[] head=Arrays.copyOfRange(arr,arr.length-1,arr.length);
        int[] tail=reverseArr(Arrays.copyOfRange(arr,0,arr.length-1));

        int[] result=new int[head.length+tail.length];

        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail,0,result,head.length,tail.length);

        return result;

    }

    public static void main(String[] args) {
        RecursivePractice p = new RecursivePractice();
        System.out.println(Arrays.toString(p.take(2, new int[]{1,2,3,4,5})));
    }
}
