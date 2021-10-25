package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1373 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split("");
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        int num8 = 0;
        Stack<String> stack = new Stack<>();
        for (int i = s.length - 1; i >= 0; i--) {

            if (Integer.parseInt(s[i]) == 1) {
                num8 += Math.pow(2, count);
            }
                count++;
            if (count == 3 || i == 0) {
                stack.add(String.valueOf(num8));
                count = 0;
                num8 = 0;
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
    }
}
