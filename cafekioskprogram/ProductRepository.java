package codeStates.cafekioskprogram;

public class ProductRepository {
    //상품들의 목록을 가지고 있고, 그 목록과 관련된 역할을 수행하는 객체

    private Product[] products=new Product[]{
            new Coffee(1,"Americano",3000,false),
            new Coffee(2,"Cafe latte",3500,false),
            new Tea(3,"Peppermint",4000,false),
            new Tea(4,"Rooibose",4500,false),
    };

    public Product[] getProducts() {
        return products;
    }

    public Product findById(int productId){
        for(Product product:getProducts()){
            if(product.getId()==productId)
                return product;
        }
        return null;
    }
}
