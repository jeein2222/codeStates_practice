package codeStates.cafekioskprogram;

public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();
        Kiosk kiosk = new Kiosk(appConfigurer.discountCondition());
        kiosk.operate();
    }
}

/*
   상품들 클래스 ; Coffee, Tea -> Product 추상화
   상품들의 목록 및 저장소 :ProductRepository
   할인 조건 : CozDiscountCondition
   프로그램 메인 로직 : Kiosk
 */
