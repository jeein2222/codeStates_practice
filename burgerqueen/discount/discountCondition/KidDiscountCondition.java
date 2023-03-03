package codeStates.burgerqueen.discount.discountCondition;

import codeStates.burgerqueen.discount.discountPolicy.DiscountPolicy;
import codeStates.burgerqueen.discount.discountPolicy.FixedAmountDiscountPolicy;

import java.util.Scanner;

//할인 조건2 : 나이가 20 미만인가
public class KidDiscountCondition implements DiscountCondition{
    private boolean isSatisfied;
    private DiscountPolicy discountPolicy;

    public KidDiscountCondition(final DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public boolean isSatisfied(){
        return isSatisfied;
    }

    private  void setSatisfied(boolean satisfied){
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition(){
        Scanner sc = new Scanner(System.in);

        System.out.println("나이가 어떻게 되십니까?");
        int input = Integer.parseInt(sc.nextLine());

        setSatisfied(input<20);
    }

    public int applyDiscount(int price){
        return discountPolicy.calculateDiscountedPrice(price);
    }
}
