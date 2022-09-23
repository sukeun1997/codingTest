package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 베스트앨범
 */
public class level3_9 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Set<Integer>> map = new HashMap<>();


        for (int i = 0; i < genres.length; i++) {
            Set<Integer> set = map.get(genres[i]);
            if (set == null) {
                set = new TreeSet<>((o1, o2) -> { if(plays[o2] == plays[o1]) {
                    return o1 - o2; }
                    return plays[o2]-plays[o1];});
                map.put(genres[i], set);
                set.add(i);
            } else {
                set.add(i);
            }
        }

        List<Map.Entry<String, Set<Integer>>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().stream().mapToInt(value -> plays[value]).sum() - o1.getValue().stream().mapToInt(value -> plays[value]).sum());

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Map.Entry<String, Set<Integer>> setEntry : entryList) {
            setEntry.getValue().stream().limit(2).forEach(integer -> arrayList.add(integer));
        }

        return arrayList.stream().mapToInt(i -> i).toArray();
    }

    @Test
    void test() {
        assertArrayEquals(
                solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 2500}), new int[]{4,1,3,0});
    }
}
