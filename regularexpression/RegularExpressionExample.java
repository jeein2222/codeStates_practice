package codeStates.regularexpression;

import java.util.*;

public class RegularExpressionExample {
    /*
        정규포현식이란 문자열 데이터 중에서 원하는 조건과 일치하는
        문자열 부분을 찾아내기 위해 사용하는 것으로, 미리 정의된 기호, 문자를 ㄹ
        이용해서 작성한 문자열을 말함.

        [정규식 기본 기호]
        . : 임의의 문자 1개
        ^ : 시작을 의미. [] 괄호 안에 있다면 일치하지 않는 부정의 의미
        $ : $ 앞의 문자열로 문자가 끝나는지를 의미
        [] : [] 괄호 안의 문자가 있는지 확인 [ab] : a,b 중 한 문자
        [^] : [] 괄호 안의 문자를 제외 [^a-z] : a-z를 제외한 모든 문자
        - : 사이읭 문자 혹은 숫자 의미.
        | : 또는 [a|b]
        () : 그룹 01(0|1) : 01 다음에 0 또는 1 들어감.
        {} : 개수 a{3}b : a가 3번 온 후 b가 온다
        \b : 공백, 탭, ",","/" 등을 의미
        \d : 0~9까지의 숫자 [0-9]
        \s : 공백, 탭
        \w : 알파벳 대소문자 + 숫자 + "_"
        ? : 앞의 표현식이 없거나 최대 한개만
        * : 앞의 표현식이 없거나 or 있거나
        | : 앞의 표현식이 1개 이상 or 여러 개
        {n} : 딱 n개 있음.
        {n, m} : n개 이상 m개 이하
        {n, } : n개 이상

        자주 사용되는 정규식 샘플
        ^[0-9]*$ : 숫자
        ^[a-zA-Z]*$ : 영문자
        ^[가-힣]*$ : 한글
        \\w+@\\w+\\.\\w+(\\.\\w+)? : 이메일
        ^\d{2,3}-\d{3,4}-\d{4}$ : 전화번호
        ^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$ : 휴대전화번호
        \d{6} \- [1-4]\d{6} : 주민등록번호
        ^\d{3}-\d{2}$ : 우편번호


        String 클래스의 정규식 문법
        boolean matches(String regrex) : 인자로 주어진 정규식에 매칭되는 값이 있는지 확인
        String replaceAll(Stirng regrex, String replacement) : 문자열 내에 있는 정규식 regrex와 매치되는 모든 문자열을 replacement 문자열로 바군 문자열을 반환
        String[] split(String regrex ) : 인자로 주어진 정규식과 매치되는 문자열을 구분자로 분할


     */
    public static void main(String[] args) {
        String email = "jeein2726@naver.com";
        System.out.println(email.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?"));

        String num="010-12*34-5689";
        String[] arr = num.split("[- | *]");
        System.out.println(Arrays.toString(arr));
    }

}
