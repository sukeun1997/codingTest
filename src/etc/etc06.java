package etc;

import java.util.Scanner;

/**
 * 왕실의 나이트 , 1초
 */
public class etc06 {

    public static void main(String[] args) {

        int move[][] = new int[][]{{2,1},{2,-1},{-2,1},{-2,-1},{1,-2},{1,2},{-1,2},{-1,-2}};

        // a = 97
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("");

        int x = split[0].charAt(0) - 96;
        int y = Integer.parseInt(split[1]);

        int count = 0;
        for (int i = 0; i < move.length; i++) {

            int nextX = x + move[i][0];
            int nextY = y + move[i][1];

            if (nextX <= 0 || nextY <= 0 || nextX > 8 || nextY > 8) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}
