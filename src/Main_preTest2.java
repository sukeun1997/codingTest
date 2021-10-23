import java.util.*;

public class Main_preTest2 {


    static int line[];
    static boolean visit[];
    static int lineCount = 0;

    public static void main(String[] args) {
        InputData inputData = process();
        solution(inputData.numOfConflict, inputData.conflicts);
    }

    private static void solution(int numOfConflict, int[][] conflicts) {

        line = new int[8];
        visit = new boolean[8];
        go(0,numOfConflict,conflicts);
        System.out.println(lineCount);
    }

    private static void go(int depth,int numOfConflict, int[][] conflicts) {
        if(depth == 8) {
            lineCount++;
            return;
        }


        for (int i = 0; i < 8 ; i++) {
            if (!visit[i]) {
                if(depth == 0) {
                    visit[i] = true;
                    line[depth] = i+1;
                    go(depth+1,numOfConflict,conflicts);
                    visit[i] = false;
                    continue;
                }

                boolean fight = false;
                for (int j = 0; j < numOfConflict ; j++) {
                    if (line[depth - 1] == conflicts[j][0]) {
                        if (i+1 == conflicts[j][1]) {
                            fight = true;
                        }
                    }
                    if (line[depth - 1] == conflicts[j][1]) {
                        if (i+1 == conflicts[j][0]) {
                            fight = true;
                        }
                    }
                }
                if(fight) {
                    continue;
                }
                visit[i] = true;
                line[depth] = i+1;
                go(depth+1,numOfConflict,conflicts);
                visit[i] = false;
            }

        }
    }


    private static InputData process() {
        InputData inputData = new InputData();

        try (Scanner sc = new Scanner(System.in)) {
            inputData.numOfConflict = Integer.parseInt(sc.nextLine());
            inputData.conflicts = new int[inputData.numOfConflict][2];

            for (int i = 0; i < inputData.numOfConflict; i++) {
                String[] temp = sc.nextLine().split(" ");
                inputData.conflicts[i][0] = Integer.parseInt(temp[0]);
                inputData.conflicts[i][1] = Integer.parseInt(temp[1]);

            }

        } catch (Exception e) {
            throw e;
        }
        return inputData;
    }
    private static class InputData {
        int numOfConflict;
        int [][] conflicts;
    }






}
