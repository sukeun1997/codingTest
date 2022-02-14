package etc;

import java.util.Arrays;
import java.util.Scanner;

public class etc15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("");

        int list[] = new int[2];

        for (int i = 0; i < split.length-1; i++) {
            int cur = Integer.parseInt(split[i]);
            int next = Integer.parseInt(split[i+1]);

            if (i == 0) {
                list[cur]++;
            }

            if (cur != next) {
                list[next]++;
            }
        }

        System.out.println(Arrays.stream(list).min().getAsInt());
    }

}
