package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가르침
 */
public class Main_1062_3 {

    private static String[] word;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        if (k < 6) {
            System.out.println(0);
            return;
        }

        k = k - 5;

        for (String s1 : word) {
            s1.replaceAll("anta", "");
            s1.replaceAll("tica", "");
        }

        boolean[] visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;


        dfs(word, k, 0, visited);

    }

    private static void dfs(String[] word, int k, int start, boolean[] visited) {
        if (k == start) {

            int count = 0;
            for (String s : word) {
                if (s == "") {
                    count++;
                    continue;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (!visited[s.charAt(i) - 'a']) {
                        break;
                    }
                    if (i == s.length() - 1) {
                        count++;
                    }

                }
            }

            max = Math.max(max, count);


            return;
        }


        for (int j = start; j < 26; j++) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(word, k + 1, j + 1, visited);
                visited[j] = false;
            }
        }
    }
}
