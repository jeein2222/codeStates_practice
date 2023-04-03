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
        permutation_with_repetition(0,r,target,result,list);
        return list;
    }

    public void permutation_with_repetition(int cnt,int r,String[] target ,String[] result,ArrayList<String[]> list){
        if(cnt==r){
            String[] newResult=result.clone();
            list.add(newResult);
            System.out.println(newResult);
            return;
        }
        for(int i=0;i<target.length;i++){
            result[cnt] = target[i];
            permutation_with_repetition(cnt+1,r,target,result,list);
        }
    }

    //reference
    public ArrayList<String[]> rockPaperScissors2(int rounds){
        ArrayList<String[]> outcomes = new ArrayList<>();
        return permutation_with_repetition2(rounds, new String[]{}, outcomes);
    }

    public ArrayList<String[]> permutation_with_repetition2(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes ){
        if(roundsToGo==0){
            outcomes.add(playedSoFar);
            return outcomes;
        }
        String[] rps = new String[]{"rock", "paper", "scissors"};

        for(int i=0;i<rps.length;i++){
            String currentPlay = rps[i];
            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length + 1);
            concatArray[concatArray.length - 1] = currentPlay;

            outcomes = permutation_with_repetition2(roundsToGo - 1, concatArray, outcomes);
        }
        return outcomes;
    }


    public static void main(String[] args) {
        Sol5_permutation_with_repetition pr = new Sol5_permutation_with_repetition();

        ArrayList<String[]> list=pr.rockPaperScissors(4);

        for(int i=0;i<list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
}
