package codeStates.algorithm.powerset;

//멱집합
/*
    {a,b,c}의 멱집합
    -{a} + {b,c}의 멱집합
            - {b} + {c}의 멱집합
                    - {c} + {}

 */
public class PowerSet {
    public void powerSet(char[] data, int n, int k,boolean[] visited){
        if(k==n){
            for(int i=0;i<n;i++){
                if(visited[i]) System.out.print(data[i]+" ");
            }
            System.out.println();
            return;
        }
        visited[k]=false;
        powerSet(data, n,k+1, visited);
        visited[k]=true;
        powerSet(data, n,k+1, visited);
    }

    public static void main(String[] args) {
        PowerSet p = new PowerSet();
        char[] data = {'a', 'b', 'c'};
        p.powerSet(data, data.length,0,new boolean[data.length] );
    }
}
