package baekjoon;

import java.util.*;

public class Main_14226_2 {

    static class Node {
        int copy, now, count;

        public Node(int copy, int now, int count) {
            this.copy = copy;
            this.now = now;
            this.count = count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int start = 1;
        int end = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();

        boolean visited[][] = new boolean[2001][2001]; //copy , now

        queue.add(new Node(0, 1, 0));
        visited[0][1] = true;


        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int now = poll.now;
            int copy = poll.copy;
            int count = poll.count;

            if (now == end) {
                System.out.println(count);
                return;
            }
            // 복사
            queue.add(new Node(now, now, count + 1));

            // 클립보드 이모티콘 붙여넣기
            int next = now + copy;
            if (copy != 0 && next <= 1000) {
                if (!visited[copy][next]) {
                    visited[copy][next] = true;
                    queue.add(new Node(copy, next, count + 1));
                }
            }

            // 이모티콘 1개 삭제
            next = now - 1;
            if (next > 0) {
                if (!visited[copy][next]) {
                    visited[copy][next] = true;
                    queue.add(new Node(copy, next, count + 1));
                }
            }


        }

    }
}
