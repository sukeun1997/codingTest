import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_15654 {

    static int n;
    static int m;
    static List<Integer> list;
    static boolean[] visit;
    static int[] result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        list = new ArrayList<>();
        visit = new boolean[n+1];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        list = list.stream().sorted().collect(Collectors.toList());
        go(0);


    }

    static void go(int start) {
        if(start == m) {
            for (int i=0; i<result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < n ; j++) {
            if (!visit[j]) {
                visit[j] = true;
                result[start] = list.get(j);
                go(start+1);
                visit[j] = false;
            }
        }

    }
}
