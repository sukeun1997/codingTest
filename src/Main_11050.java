import java.util.Scanner;

public class Main_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int up = 1, down = 1;

        for (int i = N; i > N - K; i--) {
            up *= i;
        }
        for (int i = K; i > 1; i--) {
            down *= i;
        }

        System.out.println(up/down);

    }
}
