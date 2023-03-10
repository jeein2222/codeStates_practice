package codeStates;

/*
    enum을 사용하면 여러 상수들을 보다 편리하게 선언하고 관리할 수 있게 하며,
    상수명의 중복을 피하고 타입에 대한 안정성을 보장, switch문에서 사용 가능

    상수는 대소문자 모두 작성 가능하나, 관례적으로 대문자로 작성.
    또한 각각의 열거 상수들은 객체이기 때문에, Seasons라는 이름의 열거형은 SPRING, SUMMER, FALL, WINTER 총 4개의 열거 객체를 포함하고
    있다고 말할 수 잇다.
 */
enum Seasons{
    SPRING,
    SUMMER,
    FALL,
    WINTER
}


public class EnumExample {
    public static void main(String[] args) {
        //열거형에 선언된 상수 접근 방법 : 열거형 이름.상수명
        Seasons myFavoriteSeason = Seasons.WINTER;

        switch(myFavoriteSeason){//->switch문은 char, byte, short, int, Character, Byte, Short, Integer, String, enum 타입만 가능
            case SPRING:
                System.out.println("봄");
                break;
            case SUMMER:
                System.out.println("여름");
                break;
            case FALL:
                System.out.println("가을");
                break;
            case WINTER:
                System.out.println("겨울");
                break;
        }
    }
}
