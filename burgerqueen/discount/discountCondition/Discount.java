package codeStates.burgerqueen.discount.discountCondition;

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
