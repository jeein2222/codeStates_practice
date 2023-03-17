package codeStates.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);//offer
        queue.add(2);
        queue.add(3);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());//1 2 3
        }

        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println(queue);//[4, 5, 6]
        System.out.println(queue.peek());//4
        queue.remove();
        System.out.println(queue);//[5, 6]

    }
}
