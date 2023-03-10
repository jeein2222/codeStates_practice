package codeStates;

import java.util.Scanner;

/*
    구구단 프로그램
    사용자의 입력에 따라 다른 출력결과
    - 2~9 범위의 숫자를 입력한 경우 -> 구구단 결과 출력
    - 범위를 벗어난 숫자를 입력한 경우 -> 프로그램 종료
 */
public class Gugudan {
    static int MIN_VALUE=2;
    static int MAX_VALUE=9;
    public static void gugudan(int n){
        for(int i=1;i<=9;i++)
            System.out.println(n+" * "+i +" = "+n*i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("[안내]희망하는 구구단을 숫자로 입력해주세요 (2~9) : ");
            int n=sc.nextInt();
            System.out.println(n+"단이 입력되었습니다.");
            if(n>=MIN_VALUE && n<=MAX_VALUE){
                gugudan(n);
            }else{
                System.out.println("[경고]구구단은 2단~9단까지 선택할 수 있습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }


    }
}
