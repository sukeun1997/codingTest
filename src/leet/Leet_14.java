package leet;

import java.util.HashMap;

public class Leet_14 {

    public String longestCommonPrefix(String[] strs) {

        String str = strs[0];

        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);

            }
            i++;
        }

        return str;
    }
}
