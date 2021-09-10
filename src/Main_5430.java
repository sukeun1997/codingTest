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
            boolean error = false;
            String S = br.readLine();
            List<String> AC = new ArrayList<>();
            for (int z = 0; z < S.length(); z++) {
                AC.add(String.valueOf(S.charAt(z)));
            }
            int N = Integer.parseInt(br.readLine());
            String list_s = br.readLine();
            String[] list = list_s.substring(1,list_s.length()-1).split(",");
            for (int l = 0; l < N; l++) {
                deque.add(Integer.parseInt(list[l]));
            }
            while (true) {
                if (AC.isEmpty()) {
                    break;
                }
                if (AC.get(0).equals("R")) {
                    if(AC.size() >= 2 && AC.get(0).equals("R") && AC.get(1).equals("R")) {
                        AC.remove(0);
                        AC.remove(0);
                    } else {
                        ndeque.clear();
                        Iterator x = deque.descendingIterator();
                        while (x.hasNext()) {
                            ndeque.add((Integer) x.next());
                        }
                        AC.remove(0);
                        deque.clear();
                        deque.addAll(ndeque);
                    }
                } else if (AC.get(0).equals("D")) {
                    if (deque.isEmpty()) {
                        stringBuilder.append("error").append("\n");
                        error = true;
                        break;
                    } else {
                        deque.pop();
                    }
                    AC.remove(0);
                }
            }
            if(!error) {
                if (!deque.isEmpty()) {
                    stringBuilder.append(deque).append("\n");
                } else {
                    stringBuilder.append("[]").append("\n");
                }
            }
            deque.clear();
        }
        System.out.println(stringBuilder);
    }
}
