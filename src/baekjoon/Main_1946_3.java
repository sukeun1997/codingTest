package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1946_3 {

    static StringBuilder sb = new StringBuilder();

    static class Volunteer implements Comparable<Volunteer>{

        // 서류 점수 , 면접 점수
        int document, interview;

        public Volunteer(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        // 서류 점수 기준으로 오름차순 정렬
        @Override
        public int compareTo(Volunteer o) {
            return this.document - o.document;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Volunteer> volunteers = new ArrayList<>();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            // 이전 남아있는 참가자 삭제
            volunteers.clear();

            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                volunteers.add(new Volunteer(document, interview));
            }

            // 참가자 서류 등수순으로 정렬
            Collections.sort(volunteers);

            // 신입사원의 최대 인원수
            maxRecruitment(volunteers);
        }
        System.out.println(sb.toString());

    }

    private static void maxRecruitment(List<Volunteer> volunteers) {
        int max = 1;

        /**
         *  rating
         *  처음 : 서류 1등 사람의 등수
         *  이후에는 서류 등수순으로 반복문이 진행되기 때문에 다음 사람의 제일 높은 등수로 바뀜
         */
        int rating = volunteers.get(0).interview;
        for (int i = 1; i < volunteers.size() ; i++) {
            int nextInterview = volunteers.get(i).interview;
            if (nextInterview < rating) {
                max++;
                rating = nextInterview;
            }
        }
        sb.append(max + "\n");
    }
}
