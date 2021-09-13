import java.util.Scanner;

public class Main_2630 {
    static int W = 0, B = 0;
    static int Color[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Color = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            for (int l = 0; l < N; l++) {
                Color[i][l] = sc.nextInt();
            }
        }

        colorFill(0,0,N);
        System.out.println(W);
        System.out.println(B);
    }

    public static void colorFill(int row, int col, int size) {

        if(size < 1) {
            return;
        }
        int previousColor = -1;
        boolean isAll = true;
         for (int i = row; i < row+size; i++) {
            for (int l = col; l < col+size; l++) {
                if (previousColor == -1) {
                    previousColor = Color[i][l];
                } else if (previousColor != Color[i][l]) {
                    isAll = false;
                    break;
                }
            }
             if (!isAll) {
                 break;
             }
        }
        if (!isAll) {
            size /= 2;
            colorFill(row, col, size);
            colorFill(row+size, col, size);
            colorFill(row, col+size, size);
            colorFill(row+size, col+size, size);
        } else {
            if (previousColor == 0)
                W++;
            else
                B++;
        }

    }
}
