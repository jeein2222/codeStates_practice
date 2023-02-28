package codeStates.cafekioskprogram;

import java.util.Scanner;

public class Kiosk {//프로그램 로직을 wrapping
    private ProductRepository repository = new ProductRepository();
    private DiscountCondition discountCondition;

    public Kiosk(DiscountCondition discountCondition) {//생성자 의존성 주입
        this.discountCondition = discountCondition;
    }
    /*
        의존 관계에 있는 객체를 생성자를 통해서 주입해주어 직접 객체를 생성하지 않도록
     */

    private Scanner sc = new Scanner(System.in);
    public void operate(){
        //매뉴 출력
        printMenu();
        //메뉴 입력 받음
        Product selectedProduct = chooseMenu();
        //옵션 받기 -> 상품에 다라 옵션 다르게
        selectedProduct.applyOption();
        //주문 내역 출력
        order(selectedProduct);
    }

    private void printMenu(){
        System.out.println("#메뉴");
        System.out.println("-".repeat(50));
        for(Product product: repository.getProducts()){
            System.out.printf("(%d) %-15s %d\n", product.getId(),product.getName(),product.getPrice());
        }
        System.out.println("-".repeat(50));
    }

    private Product chooseMenu(){
        System.out.println("메뉴를 골라주세요.");
        int selectedId=Integer.parseInt(sc.nextLine());
        return repository.findById(selectedId);
    }

    private void order(Product selectedProduct){
        int price = discountCondition.discount(selectedProduct.getPrice());//할인여부
        System.out.println("주문이 완료되었습니다.");
        System.out.printf("주문 상품 : %s %s\n",
                selectedProduct.getName(), selectedProduct.getOptionToString());
        System.out.printf("가격 : %d\n",price);
    }
}
