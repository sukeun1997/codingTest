package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<>();
        String st;
        while (!(st=sc.nextLine()).equals(".")) {
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '(') {
                    stack.push("(");
                }
                if (st.charAt(i) == ')') {
                    if (stack.size() == 0) {
                        System.out.println("no");
                        break;
                    }
                    if(stack.pop() != "(") {
                        System.out.println("no");
                        break;
                    }
                }
                if (st.charAt(i) == '[') {
                    stack.push("[");
                }
                if (st.charAt(i) == ']') {
                    if (stack.size() == 0) {
                        System.out.println("no");
                        break;
                    }
                    if (stack.pop() != "[") {
                        System.out.println("no");
                        break;
                    }
                }
                if(i == st.length()-1) {
                    if (stack.size() == 0) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            }
            stack.clear();
        }
    }
}
