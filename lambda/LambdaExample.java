package codeStates;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

class Member{
    private String name;
    private String id;

    public Member(){
        System.out.println("Member() 실행");
    }

    public Member(String id){
        System.out.println("Member(String id) 실행");
        this.id=id;
    }

    public Member(String name, String id){
        System.out.println("Member(String name, String id) 실행");
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

}
public class LambdaExample {
    public static void main(String[] args) throws Exception {
        /*
            Interface Function<T,R>
            T : type of input (arguments)
            R : tyep of result (return ~)

            Interface BiFunctioin<T,U,R>
            T : type of the first argument to the function
            U : type of the second argument to the function
            R : type of the result of the function
         */
        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("kimcoding");//Member(String id) 실행

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("kimcoding", "김코딩");//Member(String name, String id) 실행

    }

}
