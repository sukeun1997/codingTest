package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class level2_1 {

    static int n;

    public static int solution(int n) {
        int ans = 0;
        int start = n;
        while (start != 0) {
            if (start % 2 == 0) {
                start /= 2;
            } else {
                start -= 1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(solution(n));
    }
}
