import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 {

    static int List[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List = new int[10];
        for (int i = 1; i <= 9; i++) {
            List[i] = sc.nextInt();
        }
        int sum = Arrays.stream(List).sum();

        for (int i = 1; i < 9 ; i++) {
            for (int j = i+1; j <= 9 ; j++) {
                if (sum - List[i] - List[j] == 100) {
                    int First = i;
                    int Second = j;
                   Arrays.stream(List)
                           .sorted()
                           .filter(n -> n != List[First] && n != 0 && n != List[Second])
                           .forEach(System.out::println);
                   return;
                }
            }
        }
    }
}
