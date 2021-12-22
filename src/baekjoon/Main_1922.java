package baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1922 {

    private static class Node implements Comparable<Node> {

        int to , value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

    }

    static boolean visited[];
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    static int total = 0;
    static ArrayList<Node> arrayList[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점
        int E = sc.nextInt(); // 간선

        arrayList = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int value = sc.nextInt();
            arrayList[a].add(new Node(b, value));
            arrayList[b].add(new Node(a, value));
        }

        prim(1);
        System.out.println(total);
    }

    private static void prim(int i) {

        priorityQueue.add(new Node(1, 0));

        while (!priorityQueue.isEmpty()) {

            Node poll = priorityQueue.poll();
            int value = poll.value;
            int to = poll.to;

            if(visited[to]) continue;

            visited[to] = true;
            total += value;

            for (Node node : arrayList[to]) {
                if (!visited[node.to]) {
                    priorityQueue.add(node);
                }
            }
        }
    }
}
