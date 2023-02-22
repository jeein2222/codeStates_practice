package codeStates;

/*
 * 프로그램에 필요한 변수 선언
 * xy_lists       : 데이터를 담을 2차원 배열
 * diff           : 편차
 * diff_pow       : 편차의 제곱(double)
 * diff_pow_float : 편차의 제곱(float)
 * sum_diff_pow   : 편차 제곱의 합
 * */

// 프로그램 안내 문구 출력

// 1단계 2차원 배열 데이터 생성

// 데이터 출력 안내 문구 생성

import java.util.Scanner;

// 2단계, 3단계
// 배열 속 값을 호출하며 편차 -> 제곱 -> 합산 과정을 수행합니다.
public class Ai_V3 {
    public static double calculateVisitors(int a, int b, int money){
        return (double)a*money+b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[인공지능 프로그램 V3]");
        System.out.println("==============================");
        System.out.print("[System] a 값을 입력하여 주세요 :");
        int a=sc.nextInt();
        System.out.print("[System] b 값을 입력하여 주세요 :");
        int b=sc.nextInt();
        System.out.println("==============================");

        System.out.print("[System] 예측에 영향을 주는 원인(광고비)의 값 4개를 알려주세요 (단위 원) :");
        String[] money=sc.next().split(" ");

        System.out.print("[안내] 입력된 '광고비'는 다음과 같습니다.");
        System.out.println("1 번째) "+money[0]+" 2 번째) "+money[1]+" 3 번째) "+money[2]+" 4 번째) "+money[3]);

        System.out.println("[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");
        for(int i=0;i<4;i++){
            System.out.println((i+1)+"번 예측) "+calculateVisitors(a,b, Integer.parseInt(money[0]))+"회 방문");
        }

        
    }
}
