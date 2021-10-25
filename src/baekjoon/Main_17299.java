package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_17299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int N = sc.nextInt();

        int list_size[] = new int[1000001];
        int list[] = new int[N];
        int Ans[] = new int[N];
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            list[i] = a;
            list_size[a] += 1;
        }

        stack2.push(0);
        for (int i = 0; i < N; i++) {
            while (!stack2.isEmpty() && list_size[list[stack2.peek()]] < list_size[list[i]]) {
                Ans[stack2.pop()] = i;
            }
            stack2.push(i);
        }

        while (!stack2.isEmpty()) {
            Ans[stack2.pop()] = -1;
        }

        for (int a : Ans) {
            if (a != -1)
                stringBuilder.append(list[a]).append(" ");
            else
                stringBuilder.append(-1).append(" ");
        }
        System.out.println(stringBuilder);

    }
}
