package codeStates.datastructure;

public class DFS {
    public void dfs(int[][] graph, int v, boolean[] visited){
        if(visited[v]==false){
            visited[v]=true;
            System.out.print(v + " ");
            for(int i:graph[v]){
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS d = new DFS();
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
        d.dfs(graph, 1, visited);//1 2 7 6 8 3 4 5
    }
}
