package codeStates.burgerqueen;

public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();
        OrderApp orderApp = new OrderApp(
                appConfigurer.productRepository(),
                appConfigurer.menu(),
                appConfigurer.cart(),
                appConfigurer.order()
        );
        orderApp.start();
    }
    /*
        왜 Main 클래스의 main 메서드에 로직 코드를 작성하지 않는지..
        main이 static 메서드 이기 때문에 인스턴스 변수를 참조불가
     */

    /*
        행버거, 사이드, 음료 및 이 셋을 조합한 세트를 판매하는 패스트 푸드점.
        OrderApp
        1. 메뉴 및 상품 정보 -> Menu
           Hamburger, Drink, Side, BurgerSet -> Product 추상화
           상품 배열 -> ProductRepository
        2. 각 상품 카테고리 별로 옵션 선택 가능 -> Cart
            Hamburger : isBurgerSet, burgerSetPrice
            Side : ketchup
            Drink: hasStraw
        3. 주문 시 할인 조건 판단해서 계산 -> Order,Discount
        코드스테이츠 수강생에게 10% 할인
        20세 미만 청소년에게 500원 할인

        1.
     */
}
