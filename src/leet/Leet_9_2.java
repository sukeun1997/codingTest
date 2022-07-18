package leet;

public class Leet_9_2 {
    public boolean isPalindrome(int x) {

        String s = String.valueOf(x);

        int l = 0;
        int hi = s.length() - 1;


        while (l < hi) {

            if (s.charAt(l++) != s.charAt(hi--)) {
                return false;
            }
        }


        return true;
    }
}
