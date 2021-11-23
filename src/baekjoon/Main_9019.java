package baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class Main_9019 {

    static int n;
    static Queue<Node> queue = new LinkedList<>();
    static boolean visit[];

    private static class Node {
        private int number;
        private String command;

        public Node(int number, String command) {
            this.number = number;
            this.command = command;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(bfs(start, end));
        }
    }

    public static String bfs(int start, int end) {

        visit = new boolean[100000];
        queue.add(new Node(start, ""));

        while (!queue.isEmpty()) {

            Node remove = queue.remove();
            int number = remove.number;
            String command = remove.command;

            if (number == end) {
                queue.clear();
                return command;
            }

            int Next = 0;

            // D
            Next = D(number);
            if (!visit[Next]) {
                visit[Next] = true;
                queue.add(new Node(Next, command + "D"));
            }

            // S
            Next = S(number);
            if (!visit[Next]) {
                visit[Next] = true;
                queue.add(new Node(Next, command + "S"));
            }

            //L
            Next = L(number);
            if (!visit[Next]) {
                visit[Next] = true;
                queue.add(new Node(Next, command + "L"));
            }

            //R
            Next = R(number);
            if (!visit[Next]) {
                visit[Next] = true;
                queue.add(new Node(Next, command + "R"));
            }

        }
        return "";
    }
    static int D(int num) {
        int n = num;
        n = (n * 2) % 10000;
        return n;
    }

    static int S(int num) {
        int n = num;
        if(--n < 0) n = 9999;
        return n;
    }

    static int L(int num) {
        num = (num * 10) % 10000 + (num / 1000);
        return num;

    }

    static int R(int num) {
        num = (num / 10) + (num % 10) * 1000;
        return num;
    }

    @Test
    public void test() {

        assertEquals(Main_9019.L(1234),2341);
        assertEquals(Main_9019.R(1234),4123);

        assertEquals(Main_9019.L(1000),1);
        assertEquals(Main_9019.R(1000),100);

       assertEquals(Main_9019.bfs(1,16),"DDDD");
        assertEquals(Main_9019.bfs(1000,1),"L");

    }

}
