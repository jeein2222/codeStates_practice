package codeStates.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(int[][] graph, int v, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");
            for(int i:graph[curr]){
                if(visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS d = new BFS();
        int[][] graph={
                {},
                {2,3,8},//1에 연결되어 있는 노드
                {1,7},//2에 연결되어 있는 노드
                {1,4,5},//3에 연결되어 있는 노드
                {3,5},//4에 연결되어 있는 노드
                {3,4},//5에 연결되어 있는 노드
                {7},//6에 연결되어 있는 노드
                {2,6,8},//7에 연결되어 있는 노드
                {1,7}//8에 연결되어 있는 노드
        };
        boolean[] visited = new boolean[9];
        d.bfs(graph, 1, visited);//1 2 3 8 7 4 5 6
    }
}
