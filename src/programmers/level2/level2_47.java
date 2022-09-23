package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * 양궁대회
 */
public class level2_47 {

    private int max = 0;
    private int[] res = {-1};

    private int lion[] = new int[11];

    public int[] solution(int n, int[] info) {

        dfs(n, info, 0);

        return res;
    }

    private void dfs(int n, int[] info, int now) {

        if (now == n) {

            int peachC = 0;
            int lionC = 0;

            for (int i = 0; i < 11; i++) {
                if (info[i] != 0 || lion[i] != 0) {
                    if (info[i] >= lion[i]) {
                        peachC += 10 - i;
                    } else {
                        lionC += 10 - i;
                    }
                }
            }

            if (peachC < lionC && max <= lionC - peachC) {
                max = lionC - peachC;
                res = lion.clone();
            }
            return;
        }

        for (int i = 0; i < 11 && lion[i] <= info[i]; i++) {
            lion[i]++;
            dfs(n, info, now + 1);
            lion[i]--;
        }
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}), new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0});
    }
}
