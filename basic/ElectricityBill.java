package codeStates.basic;
/*
    구간에 따라 다르게 계산.
    <=100 -> 60.7원
    100<~<200 -> 125.9원
    200<~<300 -> 187.9원
    300<~<400 -> 280.6원
    400<~<500 -> 417.7원
    500<~ -> 670.6원
 */

import java.util.Scanner;

public class ElectricityBill {

    public static double calCulateElectricityBill(int kwh){
        int n=kwh/100;
        double[] bills={60.7,125.9,187.9,280.6,417.7,670,6};
        double bill=0;

        if(kwh<=100) bill=60.7*kwh;
        else{
            for(int i=0;i<n;i++){
                bill+=(kwh-100*(i+1))*bills[i+1];
            }
            bill+=100*60.7;
        }

        return bill;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("전기 사용량을 입력하세요 :");
            int kwh= sc.nextInt();
            System.out.println("이번 달 전기 요금은 "+calCulateElectricityBill(kwh)+"원 입니다.");
        }

    }
}
