package codeStates.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

//중복 순열
public class Sol5_permutation_with_repetition {

    //my code
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        int r=rounds;
        String[] target = {"rock", "paper", "scissors"};
        String[] result = new String[r];
        ArrayList<String[]> list= new ArrayList<>();
        permutation(0,r,target,result,list);
        return list;
    }

    public void permutation(int cnt,int r,String[] target ,String[] result,ArrayList<String[]> list){
        if(cnt==r){
            String[] newResult=result.clone();
            list.add(newResult);
            return;
        }
        for(int i=0;i<3;i++){
            result[cnt] = target[i];
            permutation(cnt+1,r,target,result,list);
        }
    }



    public static void main(String[] args) {
        Sol5_permutation_with_repetition pr = new Sol5_permutation_with_repetition();

        ArrayList<String[]> list=pr.rockPaperScissors(4);

        for(int i=0;i<list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
}
