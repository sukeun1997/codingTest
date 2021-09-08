import java.io.*;
import java.util.*;

public class Main_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list_A = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list_A.add(i);
            deque.add(i);
        }

        for (int i = 1; i <= 5; i++) {
            deque.poll();
        }

        int a = K-1;
        while (!list_A.isEmpty()) {
            deque.add(list_A.remove(a));
            if (list_A.isEmpty()) {
                break;
            }
            a += K-1;
            while (a > list_A.size() - 1) {
                a -= list_A.size();
            }
        }
        bw.append("<");
        while (!deque.isEmpty()) {
            if(deque.size() == 1) {
                bw.append(deque.pop()+"");
            } else {
                bw.append(deque.pop() + ", ");
            }
        }
        bw.append(">");
        bw.flush();
    }
}
