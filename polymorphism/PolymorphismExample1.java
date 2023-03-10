package codeStates.polymorphism;

//다형성 예제 - 참조변수의 타입 변환
class Friend{
    public void friendInfo(){
        System.out.println("나는 당신의 친구입니다.");
    }
}

class BoyFriend extends Friend{
    public void friendInfo(){
        System.out.println("나는 당신의 남자친구입니다.");
    }

    public void hangOut(){
        System.out.println("나가서 놀자!");
    }
}

class GirlFriend extends Friend{
    public void friendInfo(){
        System.out.println("나는 당신의 여자친구입니다.");
    }

    public void hangOut(){
        System.out.println("나가서 놀자!!!!!");
    }
}

public class PolymorphismExample1 {
    public static void main(String[] args) {
        Friend friend = new Friend();//객체 타입과 참조변수 타입 일치
        BoyFriend boyFriend = new BoyFriend();
        Friend girlFriend = new GirlFriend();//객체 타입과 참조변수 타입의 불일치
        /*
            상위 클래스를 참조변수의 타입으로 지정했기 때문에 참조변수가 사용할 수 있는
            멤버의 개수는 상위 클래스의 멤버의 수가 된다.
            -> 사용할 수 있는 멤버의 개수가 줄어드는데 왜 장점이 될까?
         */

        friend.friendInfo();
        boyFriend.friendInfo();
        boyFriend.hangOut();
        girlFriend.friendInfo();
//        girlFriend.hangOut(); -> 불가

        Friend girlFriend1=new GirlFriend();//업캐스팅
        GirlFriend girlFriend2= (GirlFriend) girlFriend1;//하위클래스 타입으로 상위클래스 객체 참조 -> 불가능(casting 필요)
        girlFriend2.friendInfo(); //가능
        girlFriend2.hangOut(); //가능

        //instanceof : 형변환 여부
        System.out.println(friend instanceof Object);//true
        System.out.println(friend instanceof Friend);//true
        System.out.println(friend instanceof BoyFriend);//false

        System.out.println(boyFriend instanceof Friend);//true
        System.out.println(boyFriend instanceof BoyFriend);//true

        System.out.println(girlFriend instanceof Friend);//true
        System.out.println(girlFriend instanceof GirlFriend);//true

        System.out.println(girlFriend2 instanceof Friend);//true
        System.out.println(girlFriend2 instanceof GirlFriend);//true



    }
}
