import java.util.Scanner;

public class Main_11051 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int arr[][] = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            arr[i][i] = 1;
            arr[i][0] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int k = 1; k <= N - 1; k++) {
                arr[i][k] = (arr[i - 1][k-1] + arr[i - 1][k])% 10007;
            }
        }

        System.out.println(arr[N][K] % 10007);
    }
}
