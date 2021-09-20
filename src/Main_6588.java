import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_6588 {

    static int prime[] = new int[1000001];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i * i <= 1000000; i++) {
            if (prime[i] == -1) {
                continue;
            }
            for (int l = i*i; l <= 1000000; l++) {
                if (i != l && l % i == 0) {
                    prime[l] = -1;
                }
            }
        }
        prime[0] = -1;
        prime[1] = -1;
        prime[2] = -1;
        while (sc.hasNextInt()) {
            boolean isNone = true;
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 3; i < prime.length; i++) {
                if (i == n) {
                    bw.write("Goldbach's conjecture is wrong. \n");
                    break;
                }
                if(prime[i] == -1)
                    continue;
                int l = n - i;
                if (prime[l] != 0) {
                    continue;
                }
                if (i + l == n) {
                    bw.write(n + " = " + i + " + " + l + "\n");
                    isNone = false;
                    break;
                }
            }
            bw.flush();
        }
    }

}

