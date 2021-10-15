import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1759 {


    static int l;
    static int c;
    static String list[];
    static boolean visit[];
    static char[] validate = new char[]{'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();

        list = new String[c];
        visit = new boolean[c];
        for (int i = 0; i < c; i++) {
            list[i] = sc.next();
        }
        list = Arrays.stream(list).sorted().toArray(String[]::new);
        go(0, "");
    }

    private static void go(int i,String result) {
        if (i == l) {
            int count1 = 0, count2 =0;
            for (char c1 : result.toCharArray()) {
                for (char c2 : validate) {
                    if (c1 == c2) {
                        count1++;
                    }
                }
                count2 = result.length() - count1;
            }
            if (count1 >= 1 && count2 >= 2) {
                System.out.println(result);
            }
            return;
        }

        for (int j = 0; j < c ; j++) {
            if (!visit[j]) {
                if (i > 0 && result.codePointAt(i-1) > list[j].codePointAt(0)) {
                    continue;
                }
                visit[j] = true;
                go(i + 1, result+list[j]);
                visit[j] = false;
            }

        }


    }
}
