package algorithms;

import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 가변 동적 스택
 */
// push, pop ,isEmpty , isFull
public class Stack {
    private int SP = 0;
    private int MAX_SIZE = 10;
    private int[] array = new int[MAX_SIZE];

    public void push(int item) {

        if (isFull()) {
            int[] copy = Arrays.copyOf(array, MAX_SIZE * 2);
            array = copy;
            MAX_SIZE *= 2;
        }
        array[SP++] = item;
    }
    public Object pop() {

        if (!isEmpty()) {
            return array[--SP];
        }
        return null;
    }

    public boolean isEmpty() {
        return SP == 0 ? true : false;
    }


    public boolean isFull() {
        return SP == MAX_SIZE ? true : false;
    }

    public int size() {
        return SP;
    }


    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        System.out.println(stack.size());

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.size());
        System.out.println(stack.MAX_SIZE);

        System.out.println("==================");

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.size());
        System.out.println(stack.MAX_SIZE);

        System.out.println("==================");

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.size());
        System.out.println(stack.MAX_SIZE);
    }
}
