import java.util.*;

public class Main_14002 {

    static int DP[];
    static Stack<Integer> DPLists;
    static int list[];
    static StringBuilder st = new StringBuilder();
    static int maxIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DP = new int[1001];
        list = new int[1001];
        DPLists = new Stack<>();

        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
            DP[i] = 1;
        }
        st.append(DP[Seq(n)]).append("\n");

        if(DPLists.isEmpty()) {
            st.append(list[1]);
        } else {
            while (!DPLists.isEmpty()) {
                st.append(DPLists.pop()).append(" ");
            }
        }

        System.out.println(st);
    }

    public static int Seq(int n) {
        maxIndex = 0;

        for (int i = 2; i <= n; i++) {
            for (int l = i; l >= 1; l--) {
                if (list[i] > list[l]) {
                    DP[i] = Math.max(DP[i], DP[l] + 1);
                }
                if (DP[maxIndex] < DP[i]) {
                    maxIndex = i;
                }
            }
        }
        int count = DP[maxIndex], min = maxIndex;
        while (DPLists.size() != DP[maxIndex]) {
            for (int i = min; i >= 1; i--) {
                if (DP[i] == count) {
                    if(DP[min] != count) min = i;
                    if (list[min] >= list[i]) {
                        if (DPLists.size() == Math.abs(count-DP[maxIndex]) +1 ) DPLists.pop();
                        DPLists.add(list[i]);
                        min = i;
                    }
                }
            }
            min--;
            count--;
        }
        if (maxIndex == 0) return 1;
        return maxIndex;
    }


}
