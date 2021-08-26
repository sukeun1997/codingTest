import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_9375 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        HashMap<String,Integer> clothes = new HashMap<>();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            clothes.clear();

            for(int l  = 0; l <N; l++) {
                sc.next();
                String value = sc.next();
                if (clothes.containsKey(value)) {
                    clothes.put(value, clothes.get(value) + 1);
                } else {
                    clothes.put(value, 1);
                }
            }
            int result = 1;
            for (int val : clothes.values()) {
                result *= (val + 1);
            }
            System.out.println(result-1);
        }
    }
}
