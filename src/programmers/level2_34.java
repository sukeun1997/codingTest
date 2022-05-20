package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 단체사진 찍기
 */
public class level2_34 {

    boolean [] visited;
    int [] arr;
    String[] strings;
    int ans;
    HashMap<Character, Integer> hashMap;

    public int solution(int n, String[] data) {
        ans = 0;

        visited = new boolean[8];
        arr = new int[8];
        strings = data;

        hashMap = new HashMap<>();

        hashMap.put('A', 0);
        hashMap.put('C', 1);
        hashMap.put('F', 2);
        hashMap.put('J', 3);
        hashMap.put('M', 4);
        hashMap.put('N', 5);
        hashMap.put('R', 6);
        hashMap.put('T', 7);

        dfs(0);
        return ans;


    }

    private void dfs(int idx) {

        if (idx == 8) {
            check();
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                dfs(idx+1);
                visited[i] = false;
            }
        }
    }

    private void check() {
        for (String string : strings) {
            char first = string.charAt(0);
            char second = string.charAt(2);
            char op = string.charAt(3);
            int num = string.charAt(4) -'0' + 1;

            int a = arr[hashMap.get(first)];
            int b = arr[hashMap.get(second)];
            int abs = Math.abs(a - b);

            if(!operation(op, num, abs)) {
                return;
            }
        }
        ans++;
    }

    private boolean operation(char op, int num, int abs) {

        switch (op) {

            case '=':
                if (abs == num) {
                    return true;
                }
                break;
            case '>' :
                if (abs > num) {
                    return true;
                }
                break;
            case '<' :
                if (abs < num) {
                    return true;
                }
                break;
        }
        return false;
    }

    @Test
    void test() {
        assertEquals(solution(2,new String[]{"N~F=0", "R~T>2"}),3648);
        assertEquals(solution(2,new String[]{"M~C<2", "C~M>1"}),0);
    }

}
