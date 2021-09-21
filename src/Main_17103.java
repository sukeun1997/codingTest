import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_17103 {

    static int prime[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i * i <= 1000000; i++) {
            if (prime[i] == -1) {
                continue;
            }
            for (int l = i*i; l <= 1000000; l+= i) {
                if (i != l && l % i == 0) {
                    prime[l] = -1;
                }
            }
        }
        prime[0] = -1;
        prime[1] = -1;


        int n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            int primeNum = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 2; i <= primeNum/2; i++) {
                if(prime[i] == -1)
                    continue;
                int l = primeNum - i;
                if (prime[l] != 0) {
                    continue;
                }
                if (i + l == primeNum) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();

    }

}

