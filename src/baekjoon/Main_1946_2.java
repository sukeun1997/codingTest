package baekjoon;

import java.util.*;

public class Main_1946_2 {

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

        PriorityQueue<Volunteer> volunteers = new PriorityQueue<>();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            volunteers.clear();
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                volunteers.add(new Volunteer(sc.nextInt(), sc.nextInt()));
            }

            System.out.println(maxRecruitment(volunteers));
        }

    }

    private static int maxRecruitment(PriorityQueue<Volunteer> volunteers) {
        int max = 1;

        int startScore = volunteers.poll().interview;
        int maxScore = startScore;
        while (!volunteers.isEmpty()) {
            int nextInterview = volunteers.poll().interview;
            if (nextInterview < startScore && nextInterview < maxScore) {
                max++;
                maxScore = nextInterview;
            }
        }
        return max;
    }
}
