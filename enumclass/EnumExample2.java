package codeStates.enumclass;

enum Level{
    LOW,//0
    MEDIUM,//1
    HIGH//2
}

/**
 * name() : 열거 객체가 가지고 있는 문자열을 리턴하며, 리턴되는 문자열은 열거 타입을 정의할 때 사용한 상수 이름과 동일
 * ordinal() : 열거 객체의 순번을 리턴
 * compareTo() : 주어진 매개값과 비교해서 순번 차이를 리턴
 * valueOf(String name) : 주어진 문자열의 열거 객체를 리턴
 * values(): 모든 열거 객체들을 배열로 리턴
 */
public class EnumExample2 {
    public static void main(String[] args) {
        Level myLevel=Level.MEDIUM;

        Level[] allLevels = Level.values();
        for(Level x:allLevels){
            System.out.printf("%s=%d ", x.name(), x.ordinal());
        }
        System.out.println();
        Level findLevel = Level.valueOf("LOW");
        System.out.println(findLevel);//LOW
        System.out.println(Level.LOW == Level.valueOf("LOW"));//true
        System.out.println(Level.LOW.compareTo(Level.HIGH));//-2

        switch(myLevel){
            case LOW:
                System.out.println("낮은 레벨");
                break;
            case MEDIUM:
                System.out.println("중간 레벨");
                break;
            case HIGH:
                System.out.println("높은 레벨");
                break;
        }
    }
}
