package baekjoon;

import java.util.*;

public class Main_13335 {

    private static class Truck{
        int weight, distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public void move() {
            distance++;
        }
    }
    public static void main(String[] args) {
        Queue<Truck> queue = new LinkedList<>();
        Queue<Truck> trucks = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();

        for (int i = 0; i < n; i++) {
            trucks.add(new Truck(sc.nextInt(), 1));
        }

        queue.add(trucks.poll());

        int time = 1;
        while (!queue.isEmpty() || !trucks.isEmpty()) {

            while (!queue.isEmpty() && queue.peek().distance == w) {
                queue.poll();
            }

            for (Truck truck : queue) {
                truck.move();
            }

            if (!trucks.isEmpty() && queue.stream().mapToInt(truck -> truck.weight).sum() + trucks.peek().weight <= L) {
                queue.add(trucks.poll());
            }


            time++;
        }

        System.out.println(time);
    }
}
