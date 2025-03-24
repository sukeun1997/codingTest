import java.io.FileReader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.stream.Collectors;

public class Main_preTest {


    static int attack[];
    static boolean visit[];
    static int maxAttackCount = Integer.MIN_VALUE;
    public static void main(String[] args) {
        InputData inputData = process();
        solution(inputData.numOfRegion, inputData.numOfAttack, inputData.frequencies);
    }

    private static InputData process() {
        InputData inputData = new InputData();

        try (Scanner sc = new Scanner(System.in)) {
            String[] temp = sc.nextLine().split(" ");
            inputData.numOfRegion = Integer.parseInt(temp[0]);
            inputData.numOfAttack = Integer.parseInt(temp[1]);
            inputData.frequencies = new int[inputData.numOfRegion][];

            for (int i = 0; i < inputData.numOfRegion; i++) {
                temp = sc.nextLine().split(" ");

                int numOfFrequency = Integer.valueOf(temp[0]);
                inputData.frequencies[i] = new int[numOfFrequency];
                for (int j = 0; j < numOfFrequency; j++) {
                    inputData.frequencies[i][j] = Integer.parseInt(temp[j + 1]);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return inputData;
    }
    private static class InputData {
        int numOfRegion;
        int numOfAttack;
        int [][] frequencies;
    }

    public static void solution(int numOfRegion, int numOfAttack, int[][] frequencies) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numOfRegion; i++) {
            for (int j = 0; j < numOfAttack; j++) {
                if (!list.contains(frequencies[i][j])) {
                    list.add(frequencies[i][j]);
                }
            }
        }
        attack = new int[numOfAttack];
        visit = new boolean[21];
        list = list.stream().sorted().collect(Collectors.toList());
        go(0, frequencies, list,numOfAttack);
        System.out.println(maxAttackCount);
    }

    private static void go(int depth, int[][] frequencies, List<Integer> list,int attackCount) {
        if (depth == attackCount) {
            int count = 0;
           for (int[] frequency : frequencies) {
                for (int number : frequency) {
                    if (Arrays.stream(attack).anyMatch(value -> value == number)) {
                        count++;
                    }
                }
            }
            if (count > maxAttackCount) {
                maxAttackCount = count;
            }
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if(!visit[i]) {
                if (depth > 0 && list.get(i) < attack[depth - 1]) {
                    continue;
                }
                visit[i] = true;
                attack[depth] = list.get(i);
                go(depth+1, frequencies, list, attackCount);
                visit[i] = false;
            }
        }

    }


}
