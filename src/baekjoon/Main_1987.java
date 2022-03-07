package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 알파벳
 */
public class Main_1987 {

    static int move[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char map[][];
    static int r, c;
    static int max = 0;
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        map = new char[r][c];
        visited = new boolean[26];


        for (int i = 0; i < r; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = split[j].charAt(0);
            }
        }

        visited[map[0][0] -'A'] = true;
        findMax(0,0,1);

        System.out.println(max);

    }

    // DFS
    private static void findMax(int x, int y, int count) {

        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x - move[i][0];
            int ny = y - move[i][1];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }

            char s = map[nx][ny];
            if (!visited[s- 'A']) {
                visited[s - 'A'] = true;
                findMax(nx,ny,count+1);
                visited[s - 'A'] = false;
            }
        }
    }
}
