package baekjoon;

import java.io.*;
import java.util.*;

public class Main_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new LinkedList<>();
            Deque<Integer> ndeque = new LinkedList<>();
            boolean error = false, Back = false;
            String AC = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String list_s = br.readLine();
            String[] list = list_s.substring(1, list_s.length() - 1).split(",");
            for (int l = 0; l < N; l++) {
                deque.add(Integer.parseInt(list[l]));
            }
            for (char cmd : AC.toCharArray()) {
                if (cmd == 'R') {
                    if (Back == true) {
                        Back = false;
                    } else {
                        Back = true;
                    }

                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        stringBuilder.append("error").append("\n");
                        error = true;
                        break;
                    } else {

                        if (Back)
                            deque.removeLast();
                        else
                            deque.removeFirst();
                    }
                }

            }
            if (!error) {
                if (!deque.isEmpty()) {
                    StringBuilder sb = new StringBuilder("[");
                    while (!deque.isEmpty()) {
                        sb.append(Back ? deque.removeLast() : deque.removeFirst());
                        if (deque.size() != 0)
                            sb.append(',');
                    }
                    sb.append(']').append("\n");
                    stringBuilder.append(sb);
                } else {
                    stringBuilder.append("[]").append("\n");
                }
            }
            deque.clear();
        }
        System.out.println(stringBuilder);
    }
}
