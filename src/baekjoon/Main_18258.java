package baekjoon;

import java.io.*;
import java.util.*;

public class Main_18258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            String s = stringTokenizer.nextToken();
            if (s.equals("push")) {
                int a = Integer.parseInt(stringTokenizer.nextToken());
                queue.add(a);
            }

            if (s.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(queue.remove()+"\n");
                }
            }

            if (s.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(queue.peek()+"\n");
                }
            }

            if (s.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(queue.getLast()+"\n");
                }
            }

            if (s.equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write(1+"\n");
                } else {
                    bw.write(0+"\n");
                }
            }

            if (s.equals("size")) {
                bw.write(queue.size()+"\n");
            }
        }
        bw.flush();
    }
}
