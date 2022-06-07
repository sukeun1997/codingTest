package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 영어 끝말잇기
 */
public class level2_45 {

    Set<String> wordsSet;

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        wordsSet = new HashSet<>();

        char start = '0';
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (start == '0') {
                wordsSet.add(word);
                start = word.charAt(word.length() - 1);
                continue;
            }

            // 이전 마지막 단어 != 시작단어
            if (start != word.charAt(0) || wordsSet.contains(word)) {
                getAnswer(i, n, answer);
                break;
            }

            wordsSet.add(word);
            start = word.charAt(word.length() - 1);


        }


        return answer;
    }

    private void getAnswer(int i, int n, int[] answer) {
        int seq = (i + 1) % n;
        answer[0] = seq == 0 ? n : seq;
        answer[1] = seq == 0 ? (i + 1) / n : (i + 1) / n + 1;
    }


    @Test
    void test() {

        assertArrayEquals(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}), new int[]{3, 3});

        // 탈락자 미 발생시 0,0
        assertArrayEquals(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}), new int[]{0, 0});

        //
        assertArrayEquals(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}), new int[]{1, 3});
    }
}
