import java.util.Scanner;

public class Main_1476 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ans_E = sc.nextInt();
        int ans_S = sc.nextInt();
        int ans_M = sc.nextInt();

        int E = 1, S = 1, M = 1;

        int count = 1;
        while (true) {
            if (E == ans_E && ans_S == S && ans_M == M) {
                System.out.println(count);
                break;
            }
            count++;
            E += 1;
            S += 1;
            M += 1;
            if (E > 15) {
                E = 1;
            }
            if (S > 28) {
                S = 1;
            }
            if (M > 19) {
                M = 1;
            }
        }
    }

}
