package codeStates.burgerqueen.product.subproduct;

import codeStates.burgerqueen.product.Product;

public class Drink extends Product {
    private boolean hasStraw;

    public Drink(int id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.hasStraw = hasStraw;
    }

    public Drink(Drink drink){//깊은 복사를 해주는 복사 생성자
        super(drink.getName(), drink.getPrice(), drink.getKcal());
        this.hasStraw= drink.hasStraw();
    }

    public boolean hasStraw(){
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}
