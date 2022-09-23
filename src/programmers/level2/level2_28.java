package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 오픈채팅방
 */
public class level2_28 {
    public String[] solution(String[] record) {

        StringTokenizer st;

        Queue<String[]> command = new LinkedList<>();
        Map<String, String> map = new HashMap<>();

        for (String s : record) {
            st = new StringTokenizer(s);

            String com = st.nextToken();

            String key = st.nextToken();
            if (com.equals("Enter") || com.equals("Change")) {
                map.put(key, st.nextToken());
            }

            if (com.equals("Enter")) {
                command.add(new String[]{key, "님이 들어왔습니다."});
            } else if (com.equals("Leave")) {
                command.add(new String[]{key, "님이 나갔습니다."});
            }
        }


        return command.stream().map(strings -> map.get(strings[0])+strings[1]).toArray(String[]::new);
    }

    @Test
    void test() {
        assertArrayEquals(
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}),
                new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
    }

}
