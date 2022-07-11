package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Leet_127 {

    private int answer = Integer.MAX_VALUE;

    static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> words = new HashSet<>(wordList);
        find(beginWord, endWord, words);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void find(String beginWord, String endWord, Set<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Queue<Word> queue = new LinkedList<>();

        queue.add(new Word(beginWord, 1));
        HashSet<String> visited = new HashSet<>();

        visited.add(beginWord);


        while (!queue.isEmpty()) {

            Word word = queue.poll();
            String now = word.word;
            int count = word.count;

            if (now.equals(endWord)) {
                answer = count;
                return;
            }

            for (int j = 0; j < now.length(); j++) {
                char[] ch = now.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == now.charAt(j)) continue;
                    ch[j] = c;
                    String nb = String.valueOf(ch);
                    if (set.contains(nb) && visited.add(nb)) queue.offer(new Word(nb, count + 1));
                }
            }
        }
    }


    @Test
    void test() {

        Assertions.assertEquals(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")), 5);
        Assertions.assertEquals(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")), 0);
    }

}
