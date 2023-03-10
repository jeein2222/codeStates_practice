package codeStates.basic;

import java.util.Arrays;

public class forWhile {
    public int sumTo(int num) {
        int result = 0;
        //TODO :
        for(int i=0;i<=num;i++)
            result+=i;
        return result;
    }
    public static boolean isOdd(int num) {
        //조건문을 사용하여 짝수인 경우 return false를,
        //홀수인 경우 return true;를 작성해야 합니다.
        //TODO :
        num=(int)Math.abs(num);

        while(num>1){
            num-=2;
        }

        if(num==0) return false;
        else if(num==1) return true;
        else return false;
    }

    public int factorial(int num) {
        int result = 1;
        //TODO :
        for(int i=1;i<=num;i++)
            result*=i;
        return result;
    }

    public String repeatString(String str, int num) {
        String result = "";
        // TODO:
        for(int i=0;i<num;i++)
            result+=str;
        return result;
    }

    public String makeDigits(int num) {
        String result = "";
        // TODO:
        for(int i=1;i<=num;i++)
            result+=i;
        return result;
    }

    public String makeDigits2(int num) {
        // TODO:
        int i=1;
        String result="";
        while(i<=num){
            if(i==num) result+=i;
            else result+=i+"-";
            i++;
        }
        return result;
    }

    public String makeOddDigits(int num) {
        // TODO:
        int cnt=1;
        String result="";
        int i=1;
        while(cnt<=num){
            result+=i;
            i+=2;
            cnt++;
        }
        return result;
    }

    public String makeMultiplesOfDigit(int num) {
        // TODO:
        String result="";
        for(int i=1;i<=num;i++){
            if(i%3==0) result+=i;
        }
        return result;
    }

    public int makeMultiplesOfDigit2(int num1, int num2) {
        //TODO:
        int min=Math.min(num1,num2);
        int max=Math.max(num1,num2);
        int cnt=0;

        for(int i=min;i<=max;i++){
            if(i%2==0 && i!=0) cnt++;
        }

        return cnt;
    }

    public int findTheBug(String word) {
        // TODO:
        boolean isBug=false;
        int index=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='#'){
                isBug=true;
                index=i;
            }
        }
        if(isBug==false) return -1;
        else return index;
    }

    public int countCharacter(String str, char letter) {
        // TODO:
        int cnt=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==letter) cnt++;
        }
        return cnt;
    }

    public int getMaxNumberFromString(String str) {
        // TODO:
        int max=0;
        for(int i=0;i<str.length();i++){
            int n=str.charAt(i)-'0';
            if(max<n) max=n;
        }
        return max;
    }

    public String replaceAll(String str, char from, char to) {
        // TODO:
        String result="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==from){
                result+=to;
            }else{
                result+=str.charAt(i);
            }
        }

        return result;
    }

    public String characterAndNumber(String word) {
        // TODO:
        String result="";
        for(int i=0;i<word.length();i++){
            result+=word.charAt(i)+""+i;
        }
        return result;
    }

    public int computePower(int base, int exponent) {
        // TODO:
        int result=1;
        for(int i=0;i<exponent;i++){
            result*=base;
        }

        return result;
    }

    public int getSumOfFactors(int num) {
        // TODO:
        int result=0;
        for(int i=1;i<=num;i++){
            if(num%i==0) result+=i;
        }
        return result;
    }

    public boolean isPrime(int num) {
        // TODO:
        if(countDivisors(num)==2) return true;
        return false;

    }

    public int countDivisors(int n){
        int cnt=0;
        for(int i=1;i*i<=n;i++){
            if(i*i==n) cnt++;
            else if(n%i==0) cnt+=2;
        }
        return cnt;
    }

    public static String listPrimes(int num) {
        // TODO:
        String result="";
        for(int i=2;i<=num;i++){
            int cnt=0;
            for(int j=1;j<=i;j++){
                if(i%j==0) cnt++;
            }
            if(cnt==2){
                if(i==2) result+=i;
                else result+="-"+i;
            }
        }
        return result;
    }


    public String makePermutations(String str) {
        // TODO:
        String result="";
        if(str.length()==0) return result;

        for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++){
                result+=str.charAt(i)+""+str.charAt(j)+",";
            }
        }
        return result.substring(0,result.length()-1);
    }

    public boolean hasRepeatedCharacter(String str) {
        // TODO:
        if(str.length()==0) return false;

        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j))
                    return true;
            }
        }

        return false;
    }

    public String makeMarginalString(String str) {
        // TODO:
        String result="";
        //abc
        for(int i=0;i<str.length();i++){
            for(int j=0;j<=i;j++){
                result+=str.charAt(j);
            }
        }
        return result;
    }

}
