package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class dev_02 {

    HashMap<String ,Integer> ans;

    public int solution(String[] maps) {
        int answer = 0;
        ans = new HashMap<>();

        int xLen = maps.length;
        int yLen = maps[0].split("").length;

        String[][] worlds = new String[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            String[] map = maps[i].split("");
            for (int j = 0; j < yLen; j++) {
                worlds[i][j] = map[j];
            }
        }

        boolean[][] visited = new boolean[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (!visited[i][j] && !worlds[i][j].equals(".")) {
                    TreeMap<String, Integer> war = new TreeMap<>(Comparator.reverseOrder());
                    dfs(i, j, war,visited,worlds,xLen,yLen);

                    calcWinnerScore(war);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : ans.entrySet()) {
            answer = Math.max(entry.getValue(), answer);
        }
        return answer;
    }

    private void calcWinnerScore(TreeMap<String, Integer> war) {

        int maxScore = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : war.entrySet()) {

            if (maxScore < entry.getValue()) {
                maxScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        for (Map.Entry<String, Integer> entry : war.entrySet()) {
            if (entry.getValue() < maxScore) {
                war.put(winner, war.get(winner) + entry.getValue());
                war.put(entry.getKey(), 0);
            }
        }

        for (Map.Entry<String, Integer> entry : war.entrySet()) {
            ans.put(entry.getKey(), ans.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private void dfs(int x, int y, TreeMap<String, Integer> war, boolean[][] visited, String[][] worlds, int xLen, int yLen) {
        if (x < 0 || y < 0 || x >= xLen || y >= yLen || worlds[x][y].equals(".")) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        war.put(worlds[x][y], war.getOrDefault(worlds[x][y], 0) + 1);

        dfs(x + 1, y, war, visited, worlds, xLen, yLen);
        dfs(x - 1, y, war, visited, worlds, xLen, yLen);
        dfs(x, y + 1, war, visited, worlds, xLen, yLen);
        dfs(x, y - 1, war, visited, worlds, xLen, yLen);
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new String[]{"AABCA.QA", "AABC..QX", "BBBC.Y..",".A...T.A","....EE..",".M.XXEXQ","KL.TBBBQ"}),15);
    }
}
