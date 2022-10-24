package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String find = br.readLine();

        dfs(input, find);

        System.out.println(0);
    }

    private static void dfs(String start, String find) {

        if (start.length() == find.length()) {
            if (start.equals(find)) {
                System.out.println(1);
                System.exit(0);
                return;
            } else {
                return;
            }
        }

        if (find.charAt(0) == 'B') {
            String substring = find.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            dfs(start, sb.reverse().toString());
        }

        if (find.charAt(find.length() - 1) == 'A') {
            dfs(start, find.substring(0, find.length() - 1));
        }

    }

}
