package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 */
public class level2_66 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Truck> waitTrucks = new LinkedList<>();
        Queue<Truck> crossTrucks = new LinkedList<>();


        for (int truck_weight : truck_weights) {
            waitTrucks.add(new Truck(truck_weight, 1));
        }


        while (!waitTrucks.isEmpty() || !crossTrucks.isEmpty()) { // 기다리는 , 다리를 건너는 트럭이 모두 없을 때 까지

            answer++;

            if (crossTrucks.isEmpty()) {
                crossTrucks.add(waitTrucks.poll());
                continue;
            }

            if (!crossTrucks.isEmpty()) { // 다리를 지나는 트럭이 있다면 움직인다
                int size = crossTrucks.size();

                for (int i = 0; i < size; i++) {
                    Truck crossTruck = crossTrucks.poll();

                    crossTruck.move();

                    if (!crossTruck.isPastBridge(bridge_length)) {
                        crossTrucks.add(crossTruck);
                    }
                }
            }

            if (!waitTrucks.isEmpty() && crossTrucks.stream().mapToInt(value -> value.weight).sum() + waitTrucks.peek().weight <= weight) {
                crossTrucks.add(waitTrucks.poll());
            }
        }



        return answer;
    }

    private class Truck {
        int weight , move;

        public Truck(int weight, int move) {
            this.weight = weight;
            this.move = move;
        }

        public void move() {
            move++;
        }

        public boolean isPastBridge(int bridge_length) {
            return move > bridge_length;
        }

    }

    @Test
    public void test() {
        Assertions.assertEquals(solution(2, 10, new int[]{7, 4, 5, 6}), 8);
        Assertions.assertEquals(solution(100, 100, new int[]{10}), 101);
        Assertions.assertEquals(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 110);
    }
}
