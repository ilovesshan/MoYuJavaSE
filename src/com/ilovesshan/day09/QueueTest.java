
package com.ilovesshan.day09;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/24
 * @description:
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();


        System.out.println(queue.isEmpty()); // true

        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);

        System.out.println(queue.queueToString()); // [50,40,30,20,10]

        queue.pop();
        queue.pop();

        System.out.println(queue.queueToString()); // [30,20,10]


        System.out.println(queue.peek()); // 30

        System.out.println(queue.isEmpty()); // false

    }
}
