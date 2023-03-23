package codeStates.algorithm;

//멱집합 : 주어진 집합의 모든 부분집합
//A={a,b,c,d} -> 2^4=16

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sol9_powerset {

    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        ArrayList<String[]> result = new ArrayList<>();
        powerSet(result, sideDishes, sideDishes.length, 0, new boolean[sideDishes.length]);

        result.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));

        for(int i=0;i<result.size();i++){
            System.out.println(Arrays.toString(result.get(i)));
        }

        return result;

    }
    public void powerSet(ArrayList<String[]> result,String[] data, int n, int k,boolean[] visited){//A,B,C
        ArrayList<String> list = new ArrayList<>();
        if(k==n){
            for(int i=0;i<n;i++){
                if(visited[i]) {
                    list.add(data[i]);
                }
            }
            Collections.sort(list);
            result.add(list.toArray(new String[list.size()]));
            return ;
        }
        visited[k]=true;
        powerSet(result,data, n,k+1, visited);
        visited[k]=false;
        powerSet(result, data, n,k+1, visited);
    }

    public static void main(String[] args) {
        Sol9_powerset p = new Sol9_powerset();
        p.missHouseMeal(new String[]{"a","b","c"});
    }
}
