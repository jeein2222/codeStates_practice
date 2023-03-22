package codeStates.algorithm;

//의사코드 작성법
public class PseudoCode {

    //배열의 각 요소들이 그 이전의 용소들의 합보다 큰 지 여부를 확인하는 함수
    public boolean superIncreasing(int[] arr){
        //변수 sum을 선언하고, 0번째 요소 할당
        int sum = arr[0];

        //1번째 요소부터, 가장 마지막 요소까지 순회하는 반복문을 만든다.
        for(int i=1;i<arr.length;i++){
            //만약, arr[i]가 이전 요소들의 합보다 작거나 같으면 false 리턴
            if(arr[i]<=sum){ return false;}
            //그렇지 않으면, 기조의 sum에 arr[i]를 더한다.
            else{  sum += arr[i];}
        }

        //반복문이 끝나면 true 반환
        return true;
    }

    //문자열을 입력받아 연속된 한자리 홀수 숫자 사이에 '-'를 추가한 문자열을 리턴하는 함수 작성.
    public String insertDash(String str){
        //str을 char를 요소로 가지는 char 배열로 변환
        char[] arrChar = str.toCharArray();

        //결과물을 반환할 String result 빈 문자열로 초기화
        String result = "";

        //for문으로 1번째 요소부터 가장 마지막 요소 까지 순회
        for(int i=1;i<arrChar.length;i++){
            //if 둘다 홀수라면
            if (Character.getNumericValue(arrChar[i-1]) % 2 != 0 && Character.getNumericValue(arrChar[i]) % 2 != 0) {
                // arrChar[i] + '-' 추가
                result += arrChar[i-1] + "-";
            }
            //else 둘 모두 홀수가 아니면
            else{
                //result에 arrChar[i]만 추가
                result += arrChar[i-1];
            }

            //인덱스가 마지막일 경우
            if(i== arrChar.length-1){//맨 마지막 char 추가
                result += arrChar[i];
            }
        }

        //반복문이 끝나면 result 반환
        return result;
    }

    public static void main(String[] args) {
        PseudoCode p = new PseudoCode();
        System.out.println(p.superIncreasing(new int[] {1,2,3,4,5}));
        System.out.println(p.insertDash("1235790"));
    }

}
