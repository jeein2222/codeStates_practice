package codeStates.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//방향이 없는 간선들의 목록이 주어질 때, 연결된 정점의 컴포넌트(그룹들)가 몇 개인지
public class Sol6 {
    public int connectedVertices(int[][] edges) {
        int n=Arrays.stream(edges).flatMapToInt(Arrays::stream).max().getAsInt();
        int[][] map = new int[n + 1][n + 1];
        boolean[] dp = new boolean[n + 1];

        int count = 0;

        for(int i=0;i<edges.length;i++){
            map[edges[i][0]][edges[i][1]] = 1;
            map[edges[i][1]][edges[i][0]] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<map.length;i++){
            if(dp[i]==false){
                q.add(i);
                dp[i]=true;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int j=0;j<map[curr].length;j++){
                        if(map[curr][j]==1 && dp[j]==false){
                            dp[j]=true;
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Sol6 s = new Sol6();
        int result = s.connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result); // 2
    }
}
