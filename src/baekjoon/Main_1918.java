package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_1918 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (char c : line.toCharArray()) {

            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.add(c);
                    break;
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int priority(Character peek) {
        if (peek == '*' || peek == '/') {
            return 2;
        } else if (peek == '+' || peek == '-') {
            return 1;
        }
        return 0;
    }
}
