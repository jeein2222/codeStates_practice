package codeStates.algorithm;

//거스름돈
public class Sol2_Greedy {
    public int partTimeJob(int k){
        int[] coins = {500, 100, 50, 10, 5, 1};
        int cnt=0;
        for(int i=0;i<coins.length;i++){
            cnt = cnt + k / coins[i];
            k = k % coins[i];
        }
        return cnt;
    }
    public static void main(String[] args) {

    }
}
