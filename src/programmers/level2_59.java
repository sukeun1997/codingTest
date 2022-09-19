package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 방금그곡
 */
public class level2_59 {


    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";


        m = changeInfo(m);

        int maxTime = -1;

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");

            int start = Integer.parseInt(split[0].substring(0, 2)) * 60 + Integer.parseInt(split[0].substring(3, 5));
            int end = Integer.parseInt(split[1].substring(0, 2)) * 60 + Integer.parseInt(split[1].substring(3, 5));

            int playTime = end - start;


            StringBuilder sb = new StringBuilder();
            String info = changeInfo(split[3]);

            if (playTime > info.length()) {
                while (playTime > info.length()) {
                    playTime -= info.length();
                    sb.append(info);
                }
                sb.append(info.substring(0, playTime));
            } else {
                sb.append(info, 0, playTime);
            }

            String value = sb.toString();

            if (value.contains(m) && playTime > maxTime) {
                answer = split[2];
                maxTime = playTime;
            }
        }


        return maxTime != -1 ? answer : "(None)";
    }

    private String changeInfo(String m) {
        m = m.replaceAll("A#", "H");
        m = m.replaceAll("C#", "I");
        m = m.replaceAll("D#", "J");
        m = m.replaceAll("F#", "K");
        m = m.replaceAll("G#", "L");
        return m;
    }


    @Test
    void test() {
//        Assertions.assertEquals(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}), "HELLO");
//        Assertions.assertEquals(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}), "FOO");
        Assertions.assertEquals(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}), "WORLD");
    }
}
