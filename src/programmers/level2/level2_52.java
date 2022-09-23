package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 단체사진 찍기
 */
public class level2_52 {

    char[] c = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};


    int answer = 0;

    public int solution(int n, String[] data) {

        boolean[] visited = new boolean[8];
        dfs(c.length, data, 0, visited, new ArrayList<>());
        return answer;
    }

    private void dfs(int length, String[] data, int i, boolean[] visited, ArrayList<Character> list) {

        if (i == length) {

            for (String s : data) {
                char c1 = s.charAt(0);
                char c2 = s.charAt(2);
                char op = s.charAt(3);
                int count = s.charAt(4) - '0' + 1;

                int i1 = list.indexOf(c1);
                int i2 = list.indexOf(c2);

                int dif = Math.abs(i1 - i2);
                switch (op) {
                    case '=':
                        if (dif == count) {
                            break;
                        }
                            return;

                    case '<':
                        if (dif < count) {
                            break;
                        }
                            return;


                    case '>':
                        if (dif > count) {
                            break;
                        }
                            return;
                }
            }

            answer++;

            return;
        }


        for (int j = 0; j < length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                list.add(c[j]);
                dfs(length, data, i + 1, visited, list);
                list.remove(list.size() - 1);
                visited[j] = false;
            }
        }
    }

    @Test
    void test() {

        assertEquals(solution(2, new String[]{"N~F=0", "R~T>2"}), 3648);
        assertEquals(solution(2, new String[]{"M~C<2", "C~M>1"}), 0);
    }

}
