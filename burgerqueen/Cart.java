package codeStates.burgerqueen;

import codeStates.burgerqueen.product.Product;
import codeStates.burgerqueen.product.ProductRepository;
import codeStates.burgerqueen.product.subproduct.BurgerSet;
import codeStates.burgerqueen.product.subproduct.Drink;
import codeStates.burgerqueen.product.subproduct.Hamburger;
import codeStates.burgerqueen.product.subproduct.Side;

import java.util.Scanner;

//장바구니
public class Cart {
    private Product[] items = new Product[0];
    private ProductRepository productRepository;
    private Menu menu;

    private Scanner sc = new Scanner(System.in);

    public Cart(final ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void printCart(){
        System.out.println("장바구니");
        System.out.println("-".repeat(60));

        //장바구니 상품들을 옵션정보와 함께 출력
        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n",calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        sc.nextLine();
    }

    public void addToCart(int productId){
        //product id에 해당하는 상품 찾기
        Product product=productRepository.findById(productId);

        //새로운 상품 객체 생성
        Product newProduct;
        if(product instanceof Hamburger) newProduct = new Hamburger((Hamburger) product);
        else if(product instanceof Side) newProduct = new Side((Side) product);
        else newProduct = new Drink((Drink) product);

        //옵션 설정
        chooseOption(newProduct);

        //product가 Hamburger의 인스턴스이고, isBurgetSet이 true이면 세트 구성
        if(newProduct instanceof Hamburger){
            Hamburger hamburger = (Hamburger) newProduct;
            if(hamburger.isBurgerSet()) newProduct = composeSet(hamburger);
        }


        //items에 product 추가
        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length-1]=newProduct;
        items = newItems;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", newProduct.getName());
    }

    protected void printCartItemDetails(){
        for(Product product :items){
            if(product instanceof BurgerSet){
                BurgerSet burgerSet = (BurgerSet) product;
                System.out.printf(
                        "   %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().isHasStraw() ? "있음" : "없음"
                );
            }
            else if(product instanceof Hamburger){
                System.out.printf(
                        "   %-8s %6d원 (단품)\n",
                        product.getName(),
                        product.getPrice()
                );
            }
            else if(product instanceof Side){
                System.out.printf(
                        "   %-8s %6d원 (케첩 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side)product).getKetchup()
                );
            }
            else if(product instanceof Drink){
                System.out.printf(
                        "   %-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).isHasStraw() ? "있음" : "없음"
                );
            }
        }
    }

    protected int calculateTotalPrice(){
        int totalPrice=0;
        for(Product product:items){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    private void chooseOption(Product product) {
        String input;
        if(product instanceof Hamburger){
            System.out.printf(
                    "단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)\n",
                    product.getPrice(),
                    ((Hamburger) product).getBurgerSetPrice()
            );
            input = sc.nextLine();
            if(input.equals("2")) ((Hamburger) product).setIsBurgerSet(true);
        }
        else if(product instanceof Side){
            System.out.println("케첩은 몇개가 필요하신가요?");
            input = sc.nextLine();
            ((Side) product).setKetchup(Integer.parseInt(input));
        }
        else if(product instanceof Drink){
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = sc.nextLine();

            if(input.equals("2")) ((Drink) product).setHasStraw(false);
        }
    }

    //세트일 경우, 사이드, 음료 옵션 선택, 세트 리턴
    private BurgerSet composeSet(Hamburger hamburger){
        System.out.println("사이드를 골라주세요.");
        menu.printSides(false);

        String sideId = sc.nextLine();
        Side side = (Side) productRepository.findById(Integer.parseInt(sideId));
        Side newSide = new Side(side);
        chooseOption(newSide);

        System.out.println("음료를 골라주세요.");
        menu.printDrinks(false);

        String drinkId = sc.nextLine();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(drinkId));
        Drink newDrink = new Drink(drink);
        chooseOption(newDrink);

        String name = hamburger.getName() + "세트";
        int price=hamburger.getBurgerSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name, price, kcal, hamburger, newSide, newDrink);
    }
}
