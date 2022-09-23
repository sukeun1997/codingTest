package programmers.level2;

public class level2_4 {
    public long solution(int w, int h) {

        long wl = Long.valueOf(String.valueOf(w));
        long hl = Long.valueOf(String.valueOf(h));
        long answer = wl*hl - (wl+hl - gcd(wl,hl));
        return answer;
    }

    private long gcd(long w, long h) {
        long b = w > h ? w : h;
        long s = w < h ? w : h;

        while (s != 0) {
            long temp = b % s;
            b = s;
            s = temp;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
