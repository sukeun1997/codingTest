package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(i++);
            } else if (ch == ')') {
                if (i - stack.lastElement() == 1) {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }
        }
        System.out.println(count);

    }
}
