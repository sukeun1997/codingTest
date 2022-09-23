package programmers.level2;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class level2_8 {


    public static int solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (Integer integer : scoville) {
            priorityQueue.add(integer);
        }

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() < 2) {
                return -1;
            }
            priorityQueue.add(priorityQueue.remove() + (priorityQueue.remove() * 2));
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

        solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

}
