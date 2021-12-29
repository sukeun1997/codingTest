package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1038 {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number(i,1);
        }

        Collections.sort(list);
        System.out.println(list.get(n));
    }

    private static void number(long num, int depth) {
        if (depth > 10) {
            return;
        }

        list.add(num);
        for (int i = 0; i < (num%10) ; i++) {
                number((num*10)+i,depth+1);
        }
    }
}
