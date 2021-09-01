import java.util.Scanner;
import java.util.Stack;

public class Main_10773 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int T = sc.nextInt();
            if (T == 0) {
                stack.pop();
            } else {
                stack.push(T);
            }
        }
        var sum = 0;
        for (Integer a : stack) {
            sum += a;
        }
        System.out.println(sum);
    }

}

