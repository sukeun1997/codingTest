import java.util.*;

public class Main_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean Back = true;
        for (String input : s) { //n
            for (char ch : input.toCharArray()) { //m
                if(ch == '<') {
                    Back = false;
                } else if (ch == '>') {
                    stringBuilder.append(ch);
                    Back = true;
                    continue;
                }
                if(!Back) {
                    while (!stack.isEmpty()) {
                        stringBuilder.append(stack.pop());
                    }
                    stringBuilder.append(ch);
                } else {
                    stack.push(ch);
                }
            }
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);

    }
}
