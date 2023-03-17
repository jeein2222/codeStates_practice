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

    public static void main(String[] args) {
        Sol s = new Sol();
        System.out.println(s.ABCheck("HK9J6YjrAcMbq8qKrbS3EaPRT"));
        System.out.println(s.insertDash("6734611997679419173"));
    }

}
