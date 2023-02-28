package codeStates.cafekioskprogram;

import java.util.Scanner;

public class NewDiscountCondition implements DiscountCondition{
    //할인금액을 저장하는 필드
    private final int discountRate;

    public NewDiscountCondition(int discountRate) {
        this.discountRate = discountRate;
    }

    //할인 조건을 물어보는 메서드
    private boolean checkDiscount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("백엔드 코드스테이츠 수강생입니까? (1)_예 (2)_아니오");
        String input = sc.nextLine();
        if(input.equals("1")) return true;
        else return false;
    }
    //할인 금액을 계산해주는 메서드
    private int calculateDiscountPrice(int price){
        return price= (int) (price*(1-discountRate/100.0));
    }

    //할인을 적용해주는 메서드
    public int discount(int price){
        if(checkDiscount()) {
            return calculateDiscountPrice(price);
        }
        else return price;
    }
}
