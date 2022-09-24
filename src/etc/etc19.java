package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

// 1번
public class etc19 {
    public int solution(int[][] queries) {
        int answer = 0;

        HashMap<Integer, Integer> qSize = new HashMap<>();
        HashMap<Integer, Integer> qCur = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {

            int key = queries[i][0];
            int count = queries[i][1];
            if (!qSize.containsKey(key)) {
                qCur.put(key, count);
                qSize.put(key, findSize(qCur.get(key)));
                continue;
            }

            if (qSize.get(key) < qCur.get(key) + count) {

                answer += qCur.get(key);
                qCur.put(key, qCur.get(key) + count);
                qSize.put(key, findSize(qCur.get(key)));

            } else {
                qCur.put(key, qCur.get(key) + count);
            }

        }
        return answer;
    }

    private Integer findSize(int num) {
        int size = 1;

        while (size < num) {
            size *= 2;
        }

        return size;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[][]{{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}}), 16);
    }

}
