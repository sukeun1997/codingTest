package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2493 {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int answer[] = new int[n];
        int top[] = new int[n];

        Stack<Integer> stack = new Stack<>();


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            top[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = n-1; i >= 1; i--) {

            int now = top[i];
            int next = top[i - 1];

            if (next > now) {

                answer[i] = i;

                while (!stack.isEmpty() && top[stack.peek()] < next) {
                    answer[stack.pop()] = i;
                }

            } else {
                stack.push(i);
            }
        }

        for (int i : answer) {
            System.out.print(i +" ");
        }
    }
}
