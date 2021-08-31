import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10828 {

    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            String check = stringTokenizer.nextToken();
            if (check.equals("push")) {
                stack.push(Integer.parseInt(stringTokenizer.nextToken()));
            }

            if (check.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }

            if (check.equals("size")) {
                System.out.println(stack.size());
            }

            if (check.equals("empty")) {
                if (stack.empty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            if (check.equals("top")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
