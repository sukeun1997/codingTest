import java.util.Scanner;

public class Main_1676 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Num5 = 0;

        while (N > 0) {
            int temp = N;
            while (temp % 5 == 0 ) {
                Num5++;
                temp /= 5;
            }
            N--;
        }
        System.out.println(Num5);
    }
}
