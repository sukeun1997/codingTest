package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (deque.size() != 1) {
            deque.pop();
            deque.add(deque.pop());
        }

        System.out.println(deque.getFirst());
    }
}
