package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_2504 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("");

        Stack<String> stack = new Stack<>();

        int answer = 0;
        int mul = 1;

        for (int i = 0; i < split.length; i++) {

            String now = split[i];

            if (now.equals("(")) {
                stack.push(now);
                mul *= 2;
                continue;
            }
            if (now.equals("[")) {
                stack.push(now);
                mul *= 3;
                continue;
            }

            if (now.equals(")")) {

                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    System.out.println(0);
                    return;
                }

                if (split[i - 1].equals("(")) {
                    answer += mul;
                }
                mul /= 2;
                stack.pop();
                continue;
            }

            if (now.equals("]")) {

                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    System.out.println(0);
                    return;
                }

                if (split[i - 1].equals("[")) {
                    answer += mul;
                }
                mul /= 3;
                stack.pop();
                continue;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }
}
