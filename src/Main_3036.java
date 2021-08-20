import java.util.Scanner;

public class Main_3036 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int first = sc.nextInt();
        for (int i = 1; i < N; i++) {
            int M = sc.nextInt();

            int S = Math.min(first, M);

            int val = 0;
            for (int l = 1; l <= S; l++) {
                if ((first % l == 0) && (M % l == 0)) {
                    val = l;
                }
            }
            System.out.println((first/val) + "/" + (M/val));

        }

    }
}
