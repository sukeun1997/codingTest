package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if (s.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            if (s.equals("front")) {
                stringBuilder.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
            }
            if (s.equals("back")) {
                stringBuilder.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
            }
            if (s.equals("pop_front")) {
                stringBuilder.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            }
            if (s.equals("pop_back")) {
                stringBuilder.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            }
            if (s.equals("size")) {
                stringBuilder.append(deque.size()).append("\n");
            }
            if (s.equals("empty")) {
                stringBuilder.append(deque.isEmpty() ? 1 : 0).append("\n");
            }

        }
        System.out.println(stringBuilder);
    }
}
