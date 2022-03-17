package baekjoon;

import java.util.*;

/**
 * 30
 */
public class Main_10610 {

    static Integer [] list;
    static int length;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("");

        list = new Integer[split.length];
        ArrayList<Integer> arrayList = new ArrayList<>();


        for (int i = 0; i < split.length; i++) {
            list[i] = Integer.parseInt(split[i]);
            arrayList.add(list[i]);
        }

        Collections.sort(arrayList);

        int sum = arrayList.stream().mapToInt(value -> value).sum();


        StringBuilder sb = new StringBuilder();
        if (arrayList.get(0) == 0 && sum % 3 == 0) {
            for (int i = arrayList.size()-1; i >= 0 ; i--) {
                sb.append(arrayList.get(i));
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

}
