package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class level3_3 {

    static boolean visited[];
    static ArrayList<String> arrayList;


    public String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];
        arrayList = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);
        arrayList.sort(String::compareTo);
        return arrayList.get(0).split(" ");
    }

    private void dfs(String now, String locate, String[][] tickets, int idx) {

        if (idx == tickets.length) {
            arrayList.add(locate);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if (now.equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(end, locate + " " + end, tickets, idx + 1);
                visited[i] = false;
            }

        }
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}), new String[]{"ICN", "JFK", "HND", "IAD"});
        Assertions.assertArrayEquals(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}), new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
    }
}
