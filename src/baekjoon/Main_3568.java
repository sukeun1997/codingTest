package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_3568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();


        String line = sc.nextLine();

        String[] split = line.split(" ");

        String start = split[0];
        for (int i = 1; i < split.length; i++) {
            String substring = split[i].substring(1, split[i].length() - 1);
            sb.append(start).append(substring).append(" ").append(split[i].charAt(0)).append(";\n");
        }

        System.out.println();


    }


}
