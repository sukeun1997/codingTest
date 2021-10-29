package programmers;

public class level2_3 {

    static boolean visit[][];
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int result;
    public static int[] solution(int m, int n, int[][] picture) {

        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        result = 0;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && picture[i][j] != 0) {
                    visit[i][j] = true;
                    result++;
                    findSize(m, n, i, j, picture, picture[i][j]);
                    numberOfArea++;
                }
                if(result > maxSizeOfOneArea) {
                    maxSizeOfOneArea = result;
                }
                result = 0;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void findSize(int m, int n, int x, int y, int[][] picture, int num) {
        int nextX = 1;
        int nextY = 1;

        if (picture[x][y] != num) {
            return;
        }
        if (picture[x][y] == num) {
            if (!visit[x][y]) {
                visit[x][y] = true;
                result++;
            }
        }

        if (x - nextX >=0 && !visit[x-nextX][y]) {
           findSize(m,n,x-1,y,picture,num);
        }
        if (x + nextX < m && !visit[x+nextX][y]) {
            findSize(m,n,x+1,y,picture,num);
        }

        if (y - nextY >= 0 && !visit[x][y-nextY]) {
            findSize(m,n,x,y-1,picture,num);
        }

        if (y + nextY < n && !visit[x][y+nextY]) {
            findSize(m,n,x,y+1,picture,num);
        }

    }

    public static void main(String[] args) {
        solution(6, 4, new int[][] {{ 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 }});

    }
}
