package baekjoon;

import java.util.Scanner;
import java.util.Stack;

/*
list 3 5 2 7

                i = 0   i = 1   i = 2   i = 3

(전)stack       0          0        1       1,2

ans                        1       1         1 3 3

(후)stack                  1        1,2       3




 */
public class Main_17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int N = sc.nextInt();

        int list[] = new int[N];
        int Ans[] = new int[N];
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        stack2.push(0);
        for (int i = 0; i < N; i++) {
            while (!stack2.isEmpty() && list[stack2.peek()] < list[i]) {
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
