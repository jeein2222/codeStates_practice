package codeStates;

interface Cover{
    void call();
}

class User{
    public void callProvider(Cover provider){//Provider 클래스에 의존
        provider.call();
    }
}
class Provider1 implements Cover{
    public void call(){
        System.out.println("야호");
    }
}

class Provider2 implements Cover{
    public void call(){
        System.out.println("무야호");
    }
}

public class InterfaceExample1 {
    public static void main(String[] args) {
        User user=new User();
        user.callProvider(new Provider1());
        user.callProvider(new Provider2());
    }
}
