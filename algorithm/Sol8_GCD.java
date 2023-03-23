package codeStates.algorithm;

import java.util.*;

//빼빼로 데이
public class Sol8_GCD {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        int n = gcd(M, N);
        ArrayList<Integer[]> result= new ArrayList<>();

        ArrayList<Integer> list = getDivisors(n);

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
           Integer[] l = new Integer[3];
            l[0] = list.get(i);
            l[1] = M/list.get(i);
            l[2] = N/list.get(i);
            result.add(l);
            System.out.println(Arrays.toString(l));
        }


        return result;
    }

    public ArrayList<Integer> getDivisors(int n){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=1;i*i<=n;i++){
            if(i*i==n) {
                set.add(i);
            }
            else if(n%i==0) {
                set.add(i);
                set.add(n/i);
            }
        }
        set.add(n);


        return new ArrayList<>(set);
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Sol8_GCD s = new Sol8_GCD();
        s.divideChocolateStick(1, 1);

    }
}
