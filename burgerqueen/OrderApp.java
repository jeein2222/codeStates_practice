package codeStates.burgerqueen;

import codeStates.burgerqueen.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    ProductRepository productRepository;
    Menu menu;
    Cart cart;
    Order order;

    public OrderApp(final ProductRepository productRepository, final Menu menu, final Cart cart, final Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        System.out.println(" 🍔 BurgerQueen Order Service");

        while(true){
            //메뉴출력
            menu.printMenu();
            String input = sc.nextLine();

            if(input.equals("+")){//사용자 입력이 +인 경우
                //주문내역 출력
                order.makeOrder();
                break;
            }
            else{
                int menuNumber = Integer.parseInt(input);

                if(menuNumber==0) cart.printCart();
                else if(1<=menuNumber && menuNumber<=productRepository.getAllProducts().length) cart.addToCart(menuNumber);
            }
        }
    }
}
