import java.util.LinkedList;
import java.util.Scanner;

public class Main_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        LinkedList<int []> deque = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            deque.clear();
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int l = 0; l < N; l++) {
                deque.add(new int[]{l, sc.nextInt()});
            }

            int count = 0;
            while (true) {
                int[] max = deque.stream().max((o1, o2) -> o1[1] - o2[1]).get();
                if(deque.getFirst()[1] != max[1]) {
                    deque.add(deque.pop());
                } else {
                    count++;
                    if(deque.getFirst()[0] == M) {
                        System.out.println(count);
                        break;
                    }
                    deque.pop();
                }
            }

        }
    }
}
