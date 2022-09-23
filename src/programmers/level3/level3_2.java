package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 단어변환
 */
public class level3_2 {

    static boolean[] visited;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        answer = 9999;

        if (Arrays.stream(words).noneMatch(s -> target.equals(s))) {
            return  0;
        }

        visited = new boolean[words.length];

        find(begin,target,words,0);


        return answer;
    }

    private void find(String now, String target, String[] words, int count) {

        if (now.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && isChangeable(now , words[i])) {
                visited[i] = true;
                find(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isChangeable(String now, String words) {

        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != words.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}), 4);
    }
}
