package codeStates.algorithm;

public class Sol3_Imple {
         /*
            //코딩 테스트에서 좌표 인식 및 이동
            //룩업 테이블(lookup table)


         */
    public boolean checkBoundary(int nx, int ny, int size){
        if(nx<0 || nx>size || ny<0 || ny>size) return false;
        return true;
    }
    public Integer boardGame1(int[][] board, String operation) {
        int nx=0,ny=0;
        int size = board.length-1;
        int sum=0;

        for(int i=0;i<operation.length();i++){
            if(operation.charAt(i)=='U'){
                nx=nx-1;
            }else if(operation.charAt(i)=='D'){
                nx=nx+1;
            }else if(operation.charAt(i)=='L'){
                ny=ny-1;
            }else{
               ny=ny+1;
            }

            if(checkBoundary(nx,ny,size)){
                sum += board[nx][ny];
            }else{
                return null;
            }
        }
        return sum;
    }




    public static void main(String[] args) {
        Sol3_Imple s = new Sol3_Imple();
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = s.boardGame1(board1, "RRDLLD");
        System.out.println(output1);
    }
}
