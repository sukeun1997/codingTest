package baekjoon;

import java.io.*;

public class Main_1748 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sum = 0 , count = 1, length = 10;
        for (int i = 1; i <= N ; i++) {

            if(i == length) {
                length *= 10;
                count++;
            }
            sum += count;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
