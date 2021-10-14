import java.util.Scanner;

public class Main_10971 {


    static int N;
    static int W[][];
    static int result;
    static boolean visit[];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        W = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = sc.nextInt();
            }
        }
            go(0,1);

        System.out.println(min);

    }

    private static void go(int depth,int next) {

        if (depth == N) {
            if (min > result) {
                min = result;
            }
            return;
        }

        for (int i = 1; i <= N ; i++) {
                if (i == 1 && depth != N - 1 || i == next || W[next][i] == 0) {
                    continue;
                }
                if(!visit[i]) {
                    visit[i] = true;
                    result += W[next][i];
                    go(depth + 1, i);
                    result -= W[next][i];
                    visit[i] = false;
                }
            }

        }




    }

