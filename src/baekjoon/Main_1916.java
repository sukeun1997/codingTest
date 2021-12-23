package baekjoon;

import java.util.*;

public class Main_1916 {


    private static class Node implements Comparable<Node> {
        int to;
        int value;
        int total;

        public Node(int to, int value, int total) {
            this.to = to;
            this.value = value;
            this.total = total;
        }

        @Override
        public int compareTo(Node o) {
            return (value+total) - (o.value+o.total);
        }
    }

    static boolean visited[];
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    static ArrayList<Node> arrayList[];
    static int go, end;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        arrayList = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int value = sc.nextInt();

            arrayList[a].add(new Node(b, value,0));
        }

        go = sc.nextInt();
        end = sc.nextInt();

        prim(go);

    }

    private static void prim(int i) {

        priorityQueue.add(new Node(i, 0,0));

        while (!priorityQueue.isEmpty()) {

            Node poll = priorityQueue.poll();
            int to = poll.to;
            int value = poll.value;
            int total = poll.total;

            if (visited[to]) {
                continue;
            }
            visited[to] = true;
            total += value;

            if (to == end) {
                System.out.println(total);
                return;
            }
            for (Node node : arrayList[to]) {
                if (!visited[node.to]) {
                    node.total += total;
                    priorityQueue.add(node);
                }
            }
        }

    }

}
