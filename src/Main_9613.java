import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9613 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                bw.write(st.nextToken() +" \n");
                break;
            }
            for (int l = 0; l < n; l++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int x = 0; x < list.size() - 1; x++) {
                for (int y = x + 1; y < list.size(); y++) {
                    sum += Gcd(Math.max(list.get(x), list.get(y)), Math.min(list.get(x), list.get(y)));
                }
            }
            bw.write(sum + "\n");
            list.clear();
        }
        bw.flush();
    }

    public static int Gcd(int a, int b) {
        if (b == 0) {
            return  a;
        }
        int x ,y ;


        y = a % b;
        x = b;
        return Gcd(x, y);
    }
}
