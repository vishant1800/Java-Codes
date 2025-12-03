package com.collection.learn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LearnQueue {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();

        //Add elements
        que.offer(1);
        que.offer(2);
        que.offer(3);
        que.offer(4);
        que.add(10);

        System.out.println(que);

        que.poll(); // remove element from starting because it is queue and it follows fifo
        System.out.println(que);

        System.out.println(que.peek()); // returns head element

        Iterator<Integer> it = que.iterator();
        System.out.println(it.next()); // returns topmost element

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(que);
    }
}
