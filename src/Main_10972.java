
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_10972 {

    static int N;
    static int list[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new int[N + 1];

        for (int i = 1; i<= N; i++) {
            list[i] = sc.nextInt();
        }

        int min_idx = N;
        for (int i = N; i > 1 ; i--) {
            if (list[i] < list[i - 1]) {
                continue;
            }
            min_idx = i-1;
            break;
        }

        if (min_idx == N) {
            System.out.println(-1);
            return;
        }
        int swap_idx = 0;
        for (int i = min_idx+1; i <= N ; i++) {
            if (swap_idx == 0) {
                swap_idx = i;
                continue;
            }
            if (list[i] > list[min_idx] && list[i] < list[swap_idx]) {
                swap_idx = i;
            }
        }
        swap(min_idx, swap_idx);

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(list).filter(a -> a != 0).limit(min_idx).forEach(n->stringBuilder.append(n+" "));
        Arrays.stream(list).skip(min_idx+1).sorted().forEach(n->stringBuilder.append(n +" "));

        System.out.println(stringBuilder);
    }

    private static void swap(int min_idx, int swap_idx) {
        int temp = list[min_idx];
        list[min_idx] = list[swap_idx];
        list[swap_idx] = temp;
    }
}


