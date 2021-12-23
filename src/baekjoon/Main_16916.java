package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_16916 {

    static String s;
    static String pattern;
    static int pi[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         s = br.readLine();
        pattern = br.readLine();
        pi = new int[pattern.length()];

        getPi();
        KMP();
    }

    private static void getPi() {
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j - 1];
            }
            // 맞는 경우
            if(pattern.charAt(i) == pattern.charAt(j)) {
                //i길이 문자열의 공통 길이는 j의 위치 + 1
                pi[i] = ++j;
            }
        }
    }

    private static void KMP() {
        int j= 0;

        for (int i = 0; i < s.length() ; i++) {

            while (j > 0 && s.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }

            if (s.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    System.out.println(1);
                    return;
                } else {
                    j++;
                }
            }

        }
        System.out.println(0);
    }
}
