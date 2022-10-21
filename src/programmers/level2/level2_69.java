package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 방금 그곡
 */
public class level2_69 {

    public String solution(String m, String[] musicinfos) {


        String answer = "";
        int answerTime = -1;


        m = changeInfo(m);


        for (String musicinfo : musicinfos) {
            String[] s = musicinfo.split(",");
            int start = Integer.parseInt(s[0].split(":")[0]) * 60 + Integer.parseInt(s[0].split(":")[1]);
            int end = Integer.parseInt(s[1].split(":")[0]) * 60 + Integer.parseInt(s[1].split(":")[1]);

            String key = s[2];

            int playTime = end - start;

            String changeMelody = changeInfo(s[3]);

            StringBuilder sb = new StringBuilder();

            if (playTime > changeMelody.length()) {


                while (playTime > changeMelody.length()) {
                    playTime -= changeMelody.length();
                    sb.append(changeMelody);
                }

                sb.append(changeMelody, 0, playTime);

            } else {
                sb.append(changeMelody, 0, playTime);
            }

            String playMelody = sb.toString();

            if (playMelody.contains(m) && playTime > answerTime) {
                answer = key;
                answerTime = playTime;
            }
        }


        return answer;
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
        Assertions.assertEquals(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}), "HELLO");
        Assertions.assertEquals(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}), "FOO");
        Assertions.assertEquals(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}), "WORLD");
    }
}
