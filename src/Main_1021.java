import java.util.*;

public class Main_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        LinkedList<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count  = 0;
        while (!list.isEmpty()) {
            while (deque.getFirst().intValue() == list.get(0).intValue()) {
                list.remove(0);
                deque.removeFirst();
                if (list.isEmpty()) {
                    break;
                }
            }
            if (list.isEmpty()) {
                break;
            }
            if (deque.indexOf(list.get(0).intValue()) <= (deque.size()/2)) {
                deque.addLast(deque.removeFirst());
                count++;
            } else {
                deque.addFirst(deque.removeLast());
                count++;
            }

        }

        System.out.println(count);

    }
}
