package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class nc_2 {

    int[] move = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 5, 0, 6, 0, 7};

    public int solution(int[] music) {
        int answer = 0;

        int start = 1;

        for (int next : music) {
            boolean right = false;
            boolean toWhite = false;

            if (next > start) {
                right = true;
            }

            if (isWhite(next)) {
                toWhite = true;
            }

            int count = 0;

            if (toWhite) { // 목적지가 하얀색
                if (isWhite(start)) { // 시작 검반이 하얀색
                    count = Math.abs(move[next] - move[start]);
                } else { // 시작 검반이 검은색
                    count = Math.abs(move[next] - move[start + (right ? 1 : -1)]) + 1;
                }
            } else { // 목적지가 검은색
                if (isWhite(start)) {
                    count = Math.abs(move[next - (right ? 1 : -1)] - move[start]) + 1;
                } else {
                    count = Math.abs(move[next - (right ? 1 : -1)] - move[start + (right ? 1 : -1)]) + 2;
                }
            }

            answer += count;

            start = next;
        }

        return answer;
    }

    private boolean isWhite(int next) {
        switch (next) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
            default:
                return false;
        }
    }


    @Test
    void test() {

        Assertions.assertEquals(solution(new int[]{10, 9, 4, 5, 12}), 15);
        Assertions.assertEquals(solution(new int[]{6, 4, 2, 11}), 13);
    }
}
