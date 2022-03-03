package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 부분수열의 합
 */
public class Main_14225 {

    static int n;
    static boolean number[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            list[i] = Integer.valueOf(s[i]);
        }

        Arrays.sort(list);
        number = new boolean[Arrays.stream(list).sum()+2];
        visited = new boolean[n];

        find(list, 0,0, 0);
        for (int i = 1; i < number.length; i++) {
            if (!number[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void find(int[] list, int idx, int start, int now) {

        if (idx == n+1) {
            return;
        }

        if (now > 0 && !number[now]) {
            number[now] = true;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                find(list, idx + 1, i, now + list[i]);
                visited[i] = false;
            }
        }



    }

}
