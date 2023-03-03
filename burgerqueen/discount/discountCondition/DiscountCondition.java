package codeStates.burgerqueen.discount.discountCondition;

//할인 조건 인터페이스
public interface DiscountCondition {
    void checkDiscountCondition();
    int applyDiscount(int price);
    boolean isSatisfied();
}
