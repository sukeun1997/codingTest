package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class dev_03 {


    long answer = 0;

    public long solution(int k) {

        int[] make = new int[10];

        if (k < 2) {
            return 0;
        }

        make[0] = 6;
        make[1] = 2;
        make[2] = 5;
        make[3] = 5;
        make[4] = 4;
        make[5] = 5;
        make[6] = 6;
        make[7] = 3;
        make[8] = 7;
        make[9] = 6;

        dfs(0, k, make);

        return k == 6 ? answer + 1 : answer;
    }

    private void dfs(int idx, int k, int[] make) {

        if (k == 0) {
            answer++;
            return;
        }

        for (int i = 0; i < make.length; i++) {
            if (idx == 0 && i == 0) {
                continue;
            }
            if (k - make[i] >= 0) {
                dfs(idx + 1, k - make[i], make);
            }
        }
    }

    @Test
    void test() {
//        Assertions.assertEquals(solution(5), 5);
//        Assertions.assertEquals(solution(6), 7);
//        Assertions.assertEquals(solution(11), 99);
//        Assertions.assertEquals(solution(1), 0);
    }
}
