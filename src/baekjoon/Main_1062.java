package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1062 {

    static String[] word;
    static int max = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        word = new String[n];
        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            s = s.replace("anta", "");
            s = s.replace("tica", "");
            word[i] = s;
        }

        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        find(0, 0,k);
        System.out.println(max);
    }

    private static void find(int start,int depth, int k) {

        if (depth == k- 5) {
            maxCountWord();
            return;
        }

        for (int i = start; i < 26; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                find(i,depth+1,k);
                visited[i] = false;
            }
        }
    }

    private static void maxCountWord() {

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
    }
}
