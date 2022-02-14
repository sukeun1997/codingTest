package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 문자열 재정렬
 */
public class etc18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int sum = 0;
        List<Character> list = new ArrayList<>();


        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sum += Integer.parseInt(String.valueOf(c));
                continue;
            }
            list.add(c);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (Character c : list) {
            sb.append(c);
        }
        sb.append(sum);

        System.out.println(sb.toString());

    }
}
