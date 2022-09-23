package programmers.level2;

/**
 * 양궁 대회
 */
public class level2_51 {
    int[] answer = {-1};
    int max = 0;
    int[] lion = new int[11];

    public int[] solution(int n, int[] info) {

        dfs(n, info, 0);


        return answer;
    }

    private void dfs(int n, int[] info, int i) {

        if (n == i) {
            int aRes = 0;
            int lRes = 0;

            for (int j = 0; j < 11; j++) {
                if (info[j] != 0 || lion[j] != 0) {
                    if (info[j] < lion[j]) {
                        lRes += 10 - j;
                    } else {
                        aRes += 10 - j;
                    }
                }
            }

            if (lRes > aRes && lRes - aRes >= max) {
                max = lRes - aRes;
                answer = lion.clone();
            }

            return;
        }


        for (int j = 0; j < 11 && info[j] >= lion[j]; j++) {
            lion[j]++;
            dfs(n, info, i + 1);
            lion[j]--;
        }
    }

}
