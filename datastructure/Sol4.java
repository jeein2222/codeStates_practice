package codeStates.datastructure;

import java.util.Arrays;

//인접 행렬 생성하기
public class Sol4 {
    public int[][] createMatrix(int[][] edges) {
        int n=Arrays.stream(edges).flatMapToInt(Arrays::stream).max().getAsInt();

        int[][] matrix = new int[n+1][n+1];

        for (int i = 0; i < edges.length; i++) {
            if(edges[i][2]==0){//일시 방향
                matrix[edges[i][0]][edges[i][1]]=1;
            }else{//일시 무향
                matrix[edges[i][0]][edges[i][1]]=edges[i][2];
                matrix[edges[i][1]][edges[i][0]]=edges[i][2];
            }

        }

        return matrix;
    }

    public static void main(String[] args) {
        Sol4 s = new Sol4();
        int[][] matrix=s.createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        for(int i=0;i<matrix.length;i++){
            System.out.println();
        }
    }

}
