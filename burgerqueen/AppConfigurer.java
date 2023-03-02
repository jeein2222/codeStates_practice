package codeStates.burgerqueen;

import codeStates.burgerqueen.discount.discountCondition.CozDiscountCondition;
import codeStates.burgerqueen.discount.discountCondition.Discount;
import codeStates.burgerqueen.discount.discountCondition.DiscountCondition;
import codeStates.burgerqueen.discount.discountCondition.KidDiscountCondition;
import codeStates.burgerqueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import codeStates.burgerqueen.product.ProductRepository;

public class AppConfigurer {

    private Cart cart = new Cart(productRepository(), menu());//싱글톤 패턴
    public ProductRepository productRepository(){
        return new ProductRepository();
    }
    public Menu menu(){
        return new Menu(productRepository().getAllProducts());
    }

    public Cart cart(){
        return cart;
    }

    public Discount discount(){
        return new Discount(new DiscountCondition[]{
                new CozDiscountCondition(new FixedAmountDiscountPolicy(10)),
                new KidDiscountCondition(new FixedAmountDiscountPolicy(500))
        });
    }

    public Order order(){
        return new Order(cart(), discount());
    }
}
