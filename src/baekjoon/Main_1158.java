package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1158 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque<Integer> circle = new LinkedList<>();
        StringBuilder st = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        st.append("<");
        while (!circle.isEmpty()) {
            for (int i = 1; i < K; i++) {
                circle.addLast(circle.removeFirst());
            }
            if(circle.size() > 1) {
                st.append(circle.removeFirst()).append(", ");
            } else {
                st.append(circle.removeFirst());
            }
        }
        st.append(">");
        System.out.println(st);

    }
}
