package codeStates.datastructure;

import java.util.ArrayList;
import java.util.Stack;

//브라우저 뒤로가지 앞으로 가기 _Stack
public class Sol1 {
    public ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        current.push(start);

        for(int i=0;i<actions.length;i++){
            if(actions[i].equals("-1")){//뒤로 가기
                if(prevStack.size()!=0){
                    nextStack.push(current.pop());
                    current.push(prevStack.pop());
                }
            }else if(actions[i].equals("1")){//앞으로 가기
                if(nextStack.size()!=0){
                    prevStack.push(current.pop());
                    current.push(nextStack.pop());
                }
            }else{//새로운 페이지로 이동
                prevStack.push(current.pop());
                current.push(actions[i]);
                nextStack.clear();
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
    public static void main(String[] args) {
        Sol1 s = new Sol1();
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output =s.browserStack(actions, start);
        System.out.println(output);
    }
}
