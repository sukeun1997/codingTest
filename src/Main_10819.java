
import java.util.Scanner;

public class Main_10819 {

    static int n;
    static int[] list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new int[n];
        for (int i = 0; i <n ; i++) {
            list[i] = sc.nextInt();
        }


        int max_abs = 0;
        int max_abs_idx = -1;
        int sum = 0;
        int max_sum = 0;
        int list_c[] = list.clone();
        for (int l = 1; l <= n ; l++) {
            for (int i = 0; i < n -1 ; i++) {
                for (int j = i+1; j < n ; j++) {
                    if (Math.abs(list[i] - list[j]) > max_abs) {
                        max_abs = Math.abs((list[i] - list[j]));
                        max_abs_idx = j;
                    }
                }
                if(max_abs_idx != -1)
                swap(i+1, max_abs_idx);
                sum += max_abs;
                max_abs = 0;
                max_abs_idx = -1;
            }

            if(sum > max_sum) max_sum = sum;

            if (l == n) {
                break;
            }
            sum = 0;
            list = list_c.clone();
            swap(0, l);
        }


        System.out.println(max_sum);
    }

    private static void swap(int next, int max_abs_idx) {
        int temp = list[next];
        list[next] = list[max_abs_idx];
        list[max_abs_idx] = temp;
    }
}

