package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 불량 사용자
 */
public class level3_25 {

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        String pattern = Pattern.compile("[a-z0-9]").pattern();
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replaceAll("[*]", pattern);
        }

        boolean[] visited = new boolean[user_id.length];
        Set<BanList> set = new HashSet<>();

        answer = findBadId(0, set, user_id, visited, banned_id);

        return answer;
    }

    private int findBadId(int idx, Set<BanList> banned, String[] user_id, boolean[] visited, String[] banned_id) {
        int count = 0;

        if (idx == banned_id.length) {

            if (banned.contains(new BanList(visited))) {
                return 0;
            }
            banned.add(new BanList(visited));

            return 1;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(banned_id[idx])) {
                visited[i] = true;
                count += findBadId(idx + 1, banned, user_id, visited, banned_id);
                visited[i] = false;
            }
        }


        return count;
    }


    private class BanList {
        boolean [] banList;

        public BanList(boolean[] banList) {
            this.banList = banList;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BanList banList1 = (BanList) o;
            return Arrays.equals(banList, banList1.banList);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(banList);
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}), 2);
        Assertions.assertEquals(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}), 2);
        Assertions.assertEquals(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}), 3);
    }
}
