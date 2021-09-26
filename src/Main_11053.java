import java.util.ArrayList;
import java.util.Scanner;

public class Main_11053 {

    static int DP[];
    static int list[];
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DP = new int[1001];
        list = new int[1001];

        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
            DP[i] = 1;
        }
        System.out.println(Seq(n));
    }

    public static int Seq(int n) {
        int maxIndex = 1;
        for (int i = 2; i <= n; i++) {
            for (int l = i; l >= 1; l--) {
                if (list[i] > list[l]) {
                    DP[i] = Math.max(DP[i], DP[l]+1);
                }
                if (DP[maxIndex] < DP[i]) {
                    maxIndex = i;
                }
            }
        }
        return DP[maxIndex];
    }



}
