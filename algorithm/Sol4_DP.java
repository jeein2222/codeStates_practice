package codeStates.algorithm;

//다이나믹 프로그래밍의 가장 기초적인 문제
public class Sol4_DP {
    //금고를 털어라
    public long ocean(int target, int[] type){
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for(int i=0;i<type.length;i++){
            for(int j=1;j<=target;j++){
                if(type[i]<=j)
                    dp[j] += dp[j - type[i]];
            }
        }
        return dp[target];
    }

    //동전교환 문제
    public void coin(int[] coins, int target){
        int[] dp = new int[target + 1];
        for(int i=1;i<=target;i++) dp[i]=1000001;

        for(int i=0;i<coins.length;i++){
            System.out.printf("동전 %d 사용시\n", coins[i]);
            for(int j=coins[i];j<=target;j++){
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                System.out.printf("%d %d\n",j,dp[j]);
            }
            System.out.println("-".repeat(60));
        }
        System.out.println(dp[target]);
    }

    public static void main(String[] args) {
        Sol4_DP s = new Sol4_DP();
        //금고를 털어라
        System.out.println(s.ocean(5, new int[]{1, 2, 5}));

        //동전교환 문제
        s.coin(new int[] {1,4,5,6}, 14);
    }
}
