package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 후보키
 */
public class level2_63 {

    int answer = 0;

    public int solution(String[][] relation) {


        dfs(0, new ArrayList<Integer>(), relation);

        return answer;
    }

    private void dfs(int i, ArrayList<Integer> list, String[][] relation) {

        if (i > relation[0].length) {
            return;
        }

        HashSet<String> set = new HashSet<>();

        boolean can = true;
        for (int j = 0; j < relation.length; j++) {
            String find = "";
            for (Integer seq : list) {
                find += relation[j][seq];
            }

            if (!set.contains(find)) {
                set.add(find);
            } else {
                can = false;
                break;
            }

        }

        if (can) {
            if (!isMin(list, relation)) {
                answer += 1;
            }
            return;
        }


        for (int j = i; j < relation[0].length; j++) {
            list.add(j);
            dfs(j + 1, list, relation);
            list.remove(list.size() - 1);
        }
    }

    private boolean isMin(ArrayList<Integer> list, String[][] relation) {
        ArrayList<Integer> clone = new ArrayList<>(list);

        HashSet<String> set = new HashSet<>();

        boolean ans = false;

        for (int i = 0; i < clone.size(); i++) {
            boolean can = true;

            Integer remove = clone.remove(i);

            for (int j = 0; j < relation.length; j++) {
                String find = "";
                for (Integer seq : clone) {
                    find += relation[j][seq];
                }

                if (!set.contains(find)) {
                    set.add(find);
                } else {
                    can = false;
                    break;
                }

            }

            if (can) {
                ans = true;
                break;
            }

            clone.add(i, remove);
        }

        return ans;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}), 2);
        Assertions.assertEquals(solution(new String[][]{
                {"a", "1", "aaa", "c", "ng"},
                {"a", "1", "bbb", "e", "g"},
                {"c", "1", "aaa", "d", "ng"},
                {"d", "2", "bbb", "d", "ng"}}), 5);
    }
}
