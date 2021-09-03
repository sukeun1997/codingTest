import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            stack.push(i);
            sb.append('+').append('\n');
            while (!stack.isEmpty() && (list.get(0) == stack.lastElement())) {
                stack.pop();
                list.remove(0);
                sb.append('-').append('\n');
            }
            if (i == N) {
                if(!stack.isEmpty()) {
                    System.out.println("NO");
                } else {
                    System.out.println(sb);
                    }
                }

            }
        }
    }
