import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        LinkedList<Character> list = new LinkedList<>();

        String s = br.readLine();

        for (char ch : s.toCharArray()) {
            list.add(ch);
        }
        ListIterator lier = list.listIterator();

        for (int i = 0; i < list.size(); i++) {
            lier.next();
        }
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("P")) {
                lier.add(st.nextToken());
            } else if (cmd.equals("L")) {
                if (lier.hasPrevious()) {
                    lier.previous();
                }
            } else if (cmd.equals("D")) {
                if (lier.hasNext()) {
                    lier.next();
                }
            } else if (cmd.equals("B")) {
                if (lier.hasPrevious()) {
                    lier.previous();
                    lier.remove();
                }
            }
            T--;
        }
        while (!list.isEmpty()) {
            stringBuilder.append(list.pop());
        }
        System.out.println(stringBuilder);

    }
}
