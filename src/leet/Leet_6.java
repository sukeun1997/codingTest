package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Zigzag Conversion
 */
public class Leet_6 {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder sb[] = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int j = 0;
        int length = s.length();

        while (j < length) {
            for (int idx = 0; idx < numRows && j < length; idx++) {
                sb[idx].append(s.charAt(j++));
            }

            for (int idx = numRows - 2; idx >= 1 && j < length; idx--) {
                sb[idx].append(s.charAt(j++));
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i].toString());
        }
        return sb[0].toString();
    }


    @Test
    void test() {
        Assertions.assertEquals(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    }
}
