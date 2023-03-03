package codeStates.burgerqueen.discount;

import codeStates.burgerqueen.discount.discountCondition.DiscountCondition;

//할인에 대한 로직 처리
public class Discount {
    private DiscountCondition[] discountConditions;

    public Discount(final DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public int discount(int price){
        int discountedPrice=price;

        for(DiscountCondition discountCondition:discountConditions){
            discountCondition.checkDiscountCondition();
            if(discountCondition.isSatisfied()) discountedPrice = discountCondition.applyDiscount(discountedPrice);
        }

        return discountedPrice;
    }
}
