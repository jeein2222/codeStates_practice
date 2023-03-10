package codeStates;

class Phone{}
class IPhone extends Phone{}
class Galaxy extends Phone{}

class IPhone12Pro extends IPhone{}
class IPhoneXS extends IPhone{}

class S22 extends Galaxy{}
class ZFlip3 extends Galaxy{}

class User1<T>{
    public T phone;
    public User1(T phone){
        this.phone = phone;
    }
}

class PhoneFunction{
    public static void method(User1<?> user){
        System.out.println("모든 클래스 타입");
    }
    public static void call(User1<? extends Phone> user){
        System.out.println("-".repeat(60));
        System.out.println("user.phone = "+user.phone.getClass().getSimpleName());
        System.out.println("모든 Phone은 통화를 할 수 있습니다.");
    }
    public static void faceId(User1<? extends IPhone> user){
        System.out.println("-".repeat(60));
        System.out.println("user.phone = "+user.phone.getClass().getSimpleName());
        System.out.println("IPhone만 faceID를 할 수 있습니다.");
    }
    public static void samsungPay(User1<? extends Galaxy> user){
        System.out.println("-".repeat(60));
        System.out.println("user.phone = "+user.phone.getClass().getSimpleName());
        System.out.println("Galaxy만 samsungPay를 할 수 있습니다.");
    }
    public static void recordVoice(User1<? super Galaxy> user) {
        System.out.println("-".repeat(60));
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("안드로이드 폰에서만 통화 녹음을 할 수 있습니다.");
    }
}

public class WildCardExample {
    public static void main(String[] args) {
        PhoneFunction.call(new User1<Phone>(new Phone()));
        PhoneFunction.call(new User1<IPhone>(new IPhone()));
        PhoneFunction.call(new User1<Galaxy>(new Galaxy()));
        PhoneFunction.call(new User1<IPhone12Pro>(new IPhone12Pro()));
        PhoneFunction.call(new User1<IPhoneXS>(new IPhoneXS()));
        PhoneFunction.call(new User1<S22>(new S22()));
        PhoneFunction.call(new User1<ZFlip3>(new ZFlip3()));

        System.out.println("#".repeat(100));

//        PhoneFunction.faceId(new User<Phone>(new Phone())); -> IPhone 상속 받지 않으므로
        PhoneFunction.faceId(new User1<IPhone>(new IPhone()));
//        PhoneFunction.faceId(new User<Galaxy>(new Galaxy())); -> IPhone 상속 받지 않으므로
        PhoneFunction.faceId(new User1<IPhone12Pro>(new IPhone12Pro()));
        PhoneFunction.faceId(new User1<IPhoneXS>(new IPhoneXS()));
//        PhoneFunction.faceId(new User<S22>(new S22())); -> IPhone 상속 받지 않으므로
//        PhoneFunction.faceId(new User<ZFlip3>(new ZFlip3())); -> IPhone 상속 받지 않으므로

        System.out.println("#".repeat(100));

//        PhoneFunction.samsungPay(new User<Phone>(new Phone())); -> Galaxy 상속받지 않으므로
//        PhoneFunction.samsungPay(new User<IPhone>(new IPhone()));-> Galaxy 상속받지 않으므로
        PhoneFunction.samsungPay(new User1<Galaxy>(new Galaxy()));
//        PhoneFunction.samsungPay(new User<IPhone12Pro>(new IPhone12Pro()));-> Galaxy 상속받지 않으므로
//        PhoneFunction.samsungPay(new User<IPhoneXS>(new IPhoneXS()));-> Galaxy 상속받지 않으므로
        PhoneFunction.samsungPay(new User1<S22>(new S22()));
        PhoneFunction.samsungPay(new User1<ZFlip3>(new ZFlip3()));

        System.out.println("#".repeat(100));

        PhoneFunction.recordVoice(new User1<Phone>(new Phone()));
//        PhoneFunction.recordVoice(new User<IPhone>(new IPhone()));
        PhoneFunction.recordVoice(new User1<Galaxy>(new Galaxy()));
//        PhoneFunction.recordVoice(new User<IPhone12Pro>(new IPhone12Pro())); -> Galaxy 및 Galaxy 사위 클래스가 아니므로
//        PhoneFunction.recordVoice(new User<IPhoneXS>(new IPhoneXS()));
//        PhoneFunction.recordVoice(new User<S22>(new S22()));
//        PhoneFunction.recordVoice(new User<ZFlip3>(new ZFlip3()));

    }
}
