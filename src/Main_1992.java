import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1992 {
    static int Quard[][];
    static StringBuilder st = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        Quard = new int[T + 1][T + 1];

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split("");
            for (int l = 0; l < T; l++) {
                Quard[i][l] = Integer.parseInt(s[l]);
            }
        }
        zip(0, 0, T);
        System.out.println(st);
    }

    public static void zip(int row, int col, int size) {
        if (size < 1) {
            return;
        }

        int preColor = -1;
        boolean isAll = true;

        for (int i = row; i < row + size; i++) {
            for (int l = col; l < col + size; l++) {
                if (preColor == -1) {
                    preColor = Quard[i][l];
                } else if (preColor != Quard[i][l]) {
                    isAll = false;
                    break;
                }
            }
            if (!isAll)
                break;
        }

        if (!isAll) {
            size /= 2;
            st.append("(");
            zip(row, col, size);
            zip(row, col + size, size);
            zip(row + size, col, size);
            zip(row + size, col + size, size);
            st.append(")");
        } else {
            st.append(preColor);
        }

    }
}
