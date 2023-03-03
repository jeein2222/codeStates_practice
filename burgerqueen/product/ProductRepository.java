package codeStates.burgerqueen.product;

import codeStates.burgerqueen.product.subproduct.Drink;
import codeStates.burgerqueen.product.subproduct.Hamburger;
import codeStates.burgerqueen.product.subproduct.Side;

//상품 정보 저장
public class ProductRepository {
    Product[] products={
            new Hamburger(1, "새우버거", 3500, 500, false, 4500),
            new Hamburger(2, "치킨버거", 4000, 600, false, 5000),
            new Side(3,"감자튀김",1000,300,1),
            new Side(4,"어니언링",1000,300,1),
            new Drink(5, "코카콜라", 1000, 200, true),
            new Drink(6,"제로콜라", 1000, 0, true)
    };

    public Product[] getAllProducts(){
        return products;
    }

    //ProductRepository의 자율성을 높이도록 상품 id에 해당하는 상품 검색 기능 추가
    //결합도는 낮아짐 (캡슐화)
    public Product findById(int productId){
        for(Product product : products){
            if(product.getId() == productId) return product;
        }
        return null;
    }
}
