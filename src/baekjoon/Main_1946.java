package baekjoon;

import java.util.*;

public class Main_1946 {

    static class Volunteer implements Comparable<Volunteer>{
        int document, interview;

        public Volunteer(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Volunteer o) {
            return this.document - o.document;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Volunteer> list = new ArrayList<>();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            list.clear();
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                list.add(new Volunteer(sc.nextInt(), sc.nextInt()));
            }

            Collections.sort(list);
            System.out.println(maxRecruitment(list));
        }

    }

    private static int maxRecruitment(List<Volunteer> list) {
        int max = 1;

        int startScore = list.get(0).interview;
        int maxScore = startScore;
        for (int i = 1; i < list.size() ; i++) {
            int nextInterview = list.get(i).interview;
            if (nextInterview < startScore && nextInterview < maxScore) {
                max++;
                maxScore = nextInterview;
            }
        }
        return max;
    }
}
