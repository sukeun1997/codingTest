package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class level3_19 {

    private static int ans = Integer.MAX_VALUE;
    private static boolean[] visited;


    public int solution(String begin, String target, String[] words) {


        visited = new boolean[words.length];

        dfs(begin, target, words, 0);


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private void dfs(String now, String target, String[] words, int i) {

        if (now.equals(target)) {
            ans = Math.min(ans, i);
            return;
        }

        for (int j = 0; j < words.length; j++) {
            if (!visited[j] && isChangeable(now, words[j])) {
                visited[j] = true;
                dfs(words[j], target, words, i + 1);
                visited[j] = false;
            }
        }


    }

    private boolean isChangeable(String now, String word) {

        int difCount = 0;

        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != word.charAt(i)) {
                difCount++;
            }
        }

        return difCount == 1;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}), 4);
    }

}
