package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 파일명 정렬
 */
public class level2_40 {


    public String[] solution(String[] files) {

        ArrayList<String[]> arrayList = new ArrayList<>(files.length);

        for (String file : files) {
            String head = "";
            String number = "";
            String tail = "";

            int length = file.length();
            int idx = 0;
            for (; idx < length; idx++) {
                char c = file.charAt(idx);
                if (!(c >= '0' && c <= '9')) {
                    head += c;
                } else {
                    break;
                }
            }
            for (; idx < length; idx++) {
                char c = file.charAt(idx);
                if ((c >= '0' && c <= '9')) {
                    number += c;
                } else {
                    break;
                }
            }
            for (;idx < length; idx++) {
                char c = file.charAt(idx);
                tail += c;
            }

            arrayList.add(new String[]{head, number,tail});
        }

        Collections.sort(arrayList, (o1, o2) -> {
            String s1 = o1[0].toLowerCase();
            String s2 = o2[0].toLowerCase();
            if (s1.equals(s2)) {
                return Integer.valueOf(o1[1]) - Integer.valueOf(o2[1]);
            }
            return s1.compareTo(s2);
        });

        return arrayList.stream().map(strings -> strings[0] + strings[1] + strings[2]).toArray(String[]::new);
    }

    @Test
    void test() {
//        assertArrayEquals(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}), new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"});
//        assertArrayEquals(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}), new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"});
        assertArrayEquals(solution(new String[]{"O00321", "O49qcGPHuRLR5FEfoO00321"}), new String[]{"O49qcGPHuRLR5FEfoO00321", "O00321"});
    }
}
