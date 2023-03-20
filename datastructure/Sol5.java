package codeStates.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

//주어진 인접행렬에서 한 정점으로부터 다른 정점으로 이어지는 길이 존재하는지 반환
public class Sol5 {
    public boolean getDirections(int[][] matrix, int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        boolean[] dp = new boolean[matrix.length];
        dp[from]=true;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==to) return true;

            for(int i=0;i<matrix.length;i++){
                if(matrix[curr][i]==1 && dp[i]==false){
                    dp[i]=true;
                    q.offer(i);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Sol5 s = new Sol5();
        System.out.println(s.getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2));
    }
}
