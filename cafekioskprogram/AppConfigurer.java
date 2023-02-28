package codeStates.cafekioskprogram;

public class AppConfigurer {
    //애플리케이션의 의존관계만 설정해주는 설정 파일
    public DiscountCondition discountCondition(){
        return new NewDiscountCondition(20);//여기만 바꿔주면 됨.
    }
}
