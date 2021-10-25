package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.jar.JarEntry;


public class Main { // 1037 약수

    static int N;

    public static void main(String[] args) throws IOException {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            int value = sc.nextInt();

            if(value > max ) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        System.out.println(max*min);
    }
}
