package codeStates.burgerqueen.discount.discountCondition;

import codeStates.burgerqueen.discount.discountPolicy.DiscountPolicy;
import codeStates.burgerqueen.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.Scanner;

//할인 조건 1 : 코드스테이츠 학생인가
public class CozDiscountCondition implements DiscountCondition{
    private boolean isSatisfied;
    private DiscountPolicy discountPolicy;

    public CozDiscountCondition(final DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public boolean isSatisfied(){
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied){
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition(){
        Scanner sc = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");
        String input = sc.nextLine();

        if(input.equals("1")) setSatisfied(true);
        else if(input.equals("2")) setSatisfied(false);
    }

    public int applyDiscount(int price){
        return discountPolicy.calculateDiscountedPrice(price);
    }
}
