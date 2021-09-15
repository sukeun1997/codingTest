import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9093 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (T > 0) {
            String str;
            str = sc.nextLine();
            str += '\n';

            Stack<Character> stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!stack.isEmpty()) {
                        stringBuilder.append(stack.pop());
                    }
                    stringBuilder.append(ch);
                } else {
                    stack.push(ch);
                }
            }
            T--;
        }
        System.out.println(stringBuilder);
    }
}



/*
public class Main_9093 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                for (int l = 0; l < s.length(); l++) {
                    stack.push(s.charAt(l));
                }

                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}
 */