package codeStates.recursion;

//팩토리얼
/*
    n! = 1*2*3*....n
    1! = 1
    2! = 2*1
    3! = 3*2*1

 */
public class Sol3 {
    public int factorial1(int number){
        int result=1;
        for(int i=1;i<=number;i++)
            result*=i;
        return result;
    }

    public int factorial2(int number){
        if(number<=1) return 1;
        return number * factorial2(number - 1);
    }

    public static void main(String[] args) {
        Sol3 s = new Sol3();
        System.out.println(s.factorial1(5));
        System.out.println(s.factorial2(5));
    }
}
