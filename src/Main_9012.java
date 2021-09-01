import java.util.*;

public class Main_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    if (stack.size() == 0) {
                        System.out.println("NO");
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push("(");
                }

                if(j == s.length()-1) {
                    if (stack.size() == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
            stack.clear();
        }
    }
}
