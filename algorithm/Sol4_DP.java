package codeStates.algorithm;

import java.util.Arrays;

//금고를 털어라
public class Sol4 {
    public long ocean(int target, int[] type) {
        //동전의 type을 정렬
        type = Arrays.stream(type).sorted().toArray();

        for(int i=0;i<type.length;i++){
            //기준이 되는 수 뽑기
            int biggest = type[i];

            int n = target / biggest;

            for(int j=1;j<=n;j++){
                int remain = target - biggest * j;

            }
        }
        return 1;
    }
    public static void main(String[] args) {

    }
}
