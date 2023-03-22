package codeStates.algorithm;

public class BruteForceStringMatching {

    //배열 arr에 patternArr이 포함되는지 여부 검색
    public int bruteforceStringMatch(String[] arr, String[] patternArr) {
        //입력 : n개의 문자 텍스트를 나타내는 배열 T, m개의 문자 패턴을 나타내는 배열 P
        //출력 : 일치하는 문자열이 있으면 첫번째 인덱스를 반환. 검색에 실패한 경우 -1을 반환
        int n = arr.length;
        int m = patternArr.length;
        for(int i=0;i<=n-m;i++){
            //전체 요소 개수에서 패턴 개수를 뺀 만큼만 반복. 그 수가 마지막 비교요소이기 때문
            //i 반복문은 패턴과 비교의 위치를 잡은 반복문.
            int j=0;
            //j는 전체와 패턴의 요소 하나하나를 비교한느 반복문
            while(j<m && patternArr[j].equals(arr[i+j])){
                //j가 패턴의 개수보다 커지면 안되기 때문에 개수만큼만 반복.
                //패턴에서는 j 인덱스와 전체에서는 i+j 인덱스의 값이 같은지 판단
                //같을 때 j에 +1 함.
                j=j+1;
            }
            if(j==m){
                //j와 패턴 수가 같다는 것은 패턴의 문자열과 완전히 동일한 부분이 존재한다는 의미.
                //이때 비교했던 위치를 반환
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BruteForceStringMatching bf = new BruteForceStringMatching();
        System.out.println(bf.bruteforceStringMatch(new String[]{"a","b","c","d","a"}, new String[]{"b","c","d"}));
    }
}
