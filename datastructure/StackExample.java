package codeStates.datastructure;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);//[1, 2, 3]

        System.out.println(stack.pop());//3
        System.out.println(stack);//[1, 2]
        System.out.println(stack.peek());//2
        System.out.println(stack.search(1));//2
        System.out.println(stack.search(2));//1
        if(!stack.isEmpty()) System.out.println("stack이 채워져 있습니다.");


        //ArrayListStack 사용해보기.

        ArrayListStack arrayListStack = new ArrayListStack();
        arrayListStack.push(1);
        arrayListStack.push(2);
        arrayListStack.push(3);

        System.out.println(arrayListStack.show());//[1, 2, 3]
        System.out.println(arrayListStack.pop());//3
        System.out.println(arrayListStack.show());//[1, 2]
        arrayListStack.push(4);
        System.out.println(arrayListStack.show());//[1, 2, 4]
        System.out.println(arrayListStack.search(1));//3


    }
}
