package codeStates;

import java.util.Arrays;

public class Array {
    public int getFirstElement(int[] arr) {
        if(arr.length==0) return -1;
        return arr[0];
    }

    public int getLastElement(int[] arr) {
        // TODO:
        if(arr.length==0) return -1;
        return arr[arr.length-1];
    }
    public int getNthElement(int[] arr, int index) {
        // TODO:
        if(arr.length==0) return -1;
        if(index<0 || index>arr.length-1) return -2;
        return arr[index];
    }

    public int computeSumOfAllElements(int[] arr) {
        // TODO:
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }

    public String[] getAllWords(String str) {
        // TODO:
        if(str.length()==0) return new String[] {};
        return str.split(" ");
    }

    public char[] getAllLetters(String str) {
        // TODO:
        if(str.length()==0) return new char[] {};
        return str.toCharArray();
    }

    public int getLargestElement(int[] arr) {
        // TODO:
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public String getLongestWord(String str) {
        // TODO:
        String result="";
        int maxLength=0;
        for(String s:str.split(" ")){
            if(maxLength<s.length()){
                maxLength=s.length();
                result=s;
            }
        }
        return result;
    }

    public static int[] getEvenNumbers(int[] arr) {
        // TODO:
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0) cnt++;
        }

        int[] result=new int[cnt];
        int index=0;
        for(int i=0;i<arr.length ;i++){
            if(arr[i]%2==0) {
                result[index]=arr[i];
                index++;
            }
        }
        return result;
    }

    public static int[] addToFront(int[] arr, int el) {
        // TODO:
        int[] newArr=new int[arr.length+1];
        System.arraycopy(arr,0,newArr,1,arr.length);
        newArr[0]=el;
        return newArr;
    }

    public int[] addToBack(int[] arr, int el) {
        // TODO:
        int[] newArr=new int[arr.length+1];
        System.arraycopy(arr,0,newArr,0,arr.length);
        newArr[arr.length]=el;
        return newArr;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // TODO:
        int[] newArr=new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,newArr,0,arr1.length);
        System.arraycopy(arr2,0,newArr,arr1.length,arr2.length);
        return newArr;
    }

    public int[] getElementsAfter(int[] arr, int n) {
        // TODO:
        if(n<0 || n>arr.length-1) return new int[] {};

        int[] newArr=new int[arr.length-n];
        System.arraycopy(arr,n,newArr,0,arr.length-n);
        return newArr;
    }

    public int[] getElementsUpTo(int[] arr, int n) {
        // TODO:
        if(n<0 || n>arr.length-1) return new int[] {};

        int[] newArr=new int[n];
        System.arraycopy(arr,0,newArr,0,n);
        return newArr;
    }

    public int[] getAllElementsButFirst(int[] arr) {
        // TODO:
        if(arr.length==0) return new int[] {};

        int[] newArr=new int[arr.length-1];
        System.arraycopy(arr,1,newArr,0,arr.length-1);
        return newArr;
    }

    public int[] getAllElementsButLast(int[] arr) {
        // TODO:
        if(arr.length==0) return new int[] {};

        int[] newArr=new int[arr.length-1];
        System.arraycopy(arr,0,newArr,0,arr.length-1);
        return newArr;
    }

    public int[] getAllElementsButNth(int[] arr, int n) {
        // TODO:
        if(arr.length==0) return new int[] {};
        if(n>arr.length-1) return arr;

        int[] newArr=new int[arr.length-1];
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(i==n) continue;
            else {
                newArr[index]=arr[i];
                index++;
            }
        }
        return newArr;
    }
    public static String createPhoneNumber(int[] arr) {
        // TODO:
        String result=Arrays.toString(arr);

        result=result.replace(" ","");
        result=result.replace(",","");
        result=result.replace("[","");
        result=result.replace("]","");


        if(arr.length==8) result="(010)"+result;
        if(arr.length==11) result="("+result.substring(0,3)+")"+result.substring(3);

        result=result.substring(0,9)+"-"+result.substring(9);

        return result;
    }

    public int[] fibonacci(int num) {
        // TODO:
        int[] result=new int[num+1];
        if(num==0) return new int[] {0};

        result[0]=0;
        result[1]=1;

        for(int i=2;i<=num;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result;
    }
}
