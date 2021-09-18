import java.util.Scanner;

public class Main_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int prime[] = new int[1000001];

        for (int i = 2; i * i <= N; i++) {
            if (prime[i] == -1) {
                continue;
            }
            for (int j = i * i; j <= N; j++) {
                if(j != i && j % i ==0) {
                    prime[j] = -1;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (i == 1) {
                continue;
            }
            if (prime[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
