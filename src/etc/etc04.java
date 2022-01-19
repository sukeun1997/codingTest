package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 상하좌우 ( 구현 )
 */
public class etc04 {

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = 1, y =1;
        while (st.hasMoreTokens()) {
            String now = st.nextToken();

            int nx = 0, ny = 0;
            if (now.equals("R")) {
                nx =0;
                ny = 1;
            } else if (now.equals("L")) {
                nx = 0;
                ny = -1;
            } else if (now.equals("U")) {
                nx = -1;
                ny = 0;
            } else {
                nx = 1;
                ny = 0;
            }

            int nextX = x + nx;
            int nextY = y + ny;

            if (nextX > n || nextY > n || nextX < 1 || nextY < 1) {
                continue;
            }
            x = nextX;
            y = nextY;
        }

        System.out.println(x + " " + y);
    }
}
