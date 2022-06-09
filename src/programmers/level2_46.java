package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 스킬트리
 */
public class level2_46 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {

            boolean check = true;
            int idx = 0;
            for (char c : skill_tree.toCharArray()) {
                int index = skill.indexOf(c);

                if (index == -1) {
                    continue;
                } else if (index == idx) {
                    idx++;
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer++;
            }
        }


        return answer;
    }

    /**
     * 다른사람 풀이 (정규 표현식 사용_
     * @param skill
     * @param skill_trees
     * @return
     */
    public int solutions(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            String str = it.next().replaceAll("[^" + skill + "]", "");
            int i = skill.indexOf(str);
            if (i != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }

    @Test
    void test() {
        assertEquals(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}),2);
    }
}
