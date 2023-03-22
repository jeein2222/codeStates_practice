package codeStates.dailycoding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sol {
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        if(arr.length==0) return null;
        HashMap<String, String> map=new HashMap<>();
        map.put(arr[0],arr[arr.length-1]);
        return map;
    }
    public int computeWhenDouble(double interestRate) {
        // TODO:
        /*
            money*(1+interestRate)*(1+interestRate)
         */
        double money=1;
        int year=0;
        while(money<2){
            money=money*(1+interestRate/100);
            year++;
        }
        return year;
    }

    public boolean powerOfTwo(long num) {
        // TODO:
        while(num>1){
            if(num%2==0)
                num=num/2;
            else break;
        }
        return num==1;
    }

    public String firstCharacter(String str) {
        // TODO:
        if(str=="") return str;
        String answer="";
        String[] arr=str.split(" ");
        for(int i=0;i<arr.length;i++){
            answer+=arr[i].charAt(0);
        }
        return answer;
    }

    public String firstReverse(String str) {
        // TODO:
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }

    public String letterCapitalize(String str) {
        String result = "";
        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i].isEmpty()){
                arr[i] = arr[i];
            }else{
                arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
            }
        }

        result = String.join(" ", arr);
        return result;

    }

    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        HashMap<String,String> map=new HashMap<>();
        if(arr.length==0) return map;

        for(int i=0;i<arr.length;i++){
            if(arr[i].length==0) continue;
            else {
                if(!map.containsKey(arr[i][0])) map.put(arr[i][0],arr[i][1]);
            }
        }
        return map;
    }
    public String convertDoubleSpaceToSingle(String str) {
        String[] arr = str.split(" ");
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(!arr[i].isEmpty()){
                list.add(arr[i].trim());
            }
        }
        return String.join(" ",list);
    }

    public boolean ABCheck(String str) {
//        str = str.toLowerCase();
//        System.out.println(str);
//        Pattern pattern1= Pattern.compile("[a]"+"..."+"[b]");
//        Pattern pattern2= Pattern.compile("[b]"+"..."+"[a]");
//        Matcher matcher1=pattern1.matcher(str);
//        Matcher matcher2=pattern2.matcher(str);
//        System.out.println(matcher1.find());
//        System.out.println(matcher2.find());
//
//        return matcher1.find()||matcher2.find();
        if(str.length()==0) return false;
        str = str.toLowerCase();
        for(int i=4;i<str.length();i++){
            if((str.charAt(i)=='a' && str.charAt(i-4)=='b') || (str.charAt(i)=='b' && str.charAt(i-4)=='a')){
                return true;
            }
        }
        return false;
    }

    public String insertDash(String str) {
//        if(str.length()==0) return null;
//        String[] arr = str.split("");
//
//        for(int i=0;i<arr.length-1;i++){
//            int cur = Integer.valueOf(arr[i]);
//            int next = Integer.valueOf(arr[i+1]);
//
//            if(cur %2 !=0 && next %2 !=0){
//                arr[i] = arr[i] + "-";
//            }
//        }
//        str = String.join("", arr);
//
//        return str;
        if(str.length()==0) return null;
        String result = ""+str.charAt(0);
        for(int i=0;i<str.length()-1;i++){
            int cur = Character.getNumericValue(str.charAt(i));
            int next = Character.getNumericValue(str.charAt(i + 1));
            if(cur%2!=0 && next%2!=0) {
                result += "-";
            }
            result += str.charAt(i+1);
        }
        return result;
    }
    public String[] removeExtremes(String[] arr) {
        if(arr.length==0) return null;
        String[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(newArr, (s1, s2) -> s1.length() - s2.length());

        int minLen = newArr[0].length();
        int maxLen = newArr[newArr.length - 1].length();
        boolean min=false;
        boolean max=false;

        ArrayList<String> list = new ArrayList<>();

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length()==minLen && min==false){
                min=true;
            }
            else if(arr[i].length()==maxLen && max==false){
                max=true;
            }else{
                list.add(arr[i]);
            }
        }

        Collections.reverse(list);
        return list.stream().toArray(String[]::new);

    }

    public int[] reverseArr(int[] arr){
//        if(arr.length==0) return new int[] {};
//        else if(arr.length==1) return new int[]{arr[0]};
//        else{
//            int[] newArr = new int[arr.length];
//            newArr[newArr.length-1] = arr[0];
//            arr = Arrays.copyOfRange(arr, 1, arr.length);
//            System.arraycopy(reverseArr(arr), 0, newArr, 0, arr.length);
//            return newArr;
//        }
        if(arr.length==0) return new int[] {};
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));

        int[] dest = new int[head.length + tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);
        return dest;
    }

    public String readVertically(String[] arr) {
        int maxLength = Arrays.stream(arr).mapToInt(String::length).max().getAsInt();
        String result = "";
        for(int i=0;i<maxLength;i++){
            for(int j=0;j<arr.length;j++){
                try{
                    result += arr[j].charAt(i);
                }catch (StringIndexOutOfBoundsException e){
                }

            }
        }
        /*
            "hello"
            "world"
            "nice"
            "hi"
         */
        return result;
    }
    public static void main(String[] args) {
        Sol s = new Sol();
        String result = s.readVertically(new String[]{
                "hi",
                "wolrd",
        });
        System.out.println(result);
    }

}
