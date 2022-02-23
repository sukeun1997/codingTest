package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가르침 비트마스크
 */
public class Main_1062_2 {

    static int n, k;
    static String [] word;

    static int flag = 0;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        word = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            word[i] = line.substring(4, line.length() - 4);
        }

        flag |= 1 << ('a' - 'a');
        flag |= 1 << ('n' - 'a');
        flag |= 1 << ('t' - 'a');
        flag |= 1 << ('i' - 'a');
        flag |= 1 << ('c' - 'a');
        find(0, 0, flag);
        System.out.println(max);


    }

    private static void find(int idx, int start, int flag) {
        if (idx == k - 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean isValid = true;
                for (int j = 0; j < word[i].length(); j++) {

                    if ((flag & 1 << (word[i].charAt(j) - 'a')) == 0) {
                        isValid = false;
                       break;
                    }

                }
                if (isValid) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if( (flag & 1 << i) != 0) continue;
            find(idx + 1, i+1, flag | 1 << i);
        }
    }
}
