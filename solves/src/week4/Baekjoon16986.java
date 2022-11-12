package week4;

import java.util.Scanner;

public class Baekjoon16986 {
    static int ret = 0;
    static int N;
    static int K;
    static int[][] handType;
    static int[][] playerPattern;
    static int[] patternIndex;
    static int[] playerWin;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        handType = new int[N][N];
        playerPattern = new int[2][20];
        patternIndex = new int[2];
        playerWin = new int[2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) handType[i][j] = sc.nextInt();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 20; j++) playerPattern[i][j] = sc.nextInt() - 1;
        }

        doBattle(2, 0, 0);
        System.out.println(ret);
    }

    public static void doBattle(int player1, int player2, int win) {

        if (win == K) {
            ret = 1;
            return ;
        }

        if (playerWin[0] == K || playerWin[1] == K) return ;
        if (checkVisited()) return ;

        if (player1 != 2) {
            int playerType = playerPattern[player1][patternIndex[player1]];
            int versusType = playerPattern[player2][patternIndex[player2]];
            patternIndex[0]++;
            patternIndex[1]++;

            if (handType[playerType][versusType] == 2) {

                playerWin[player1]++;
                doBattle(2, player1, win);
                playerWin[player1]--;

            }
            else {
                playerWin[player2]++;
                doBattle(2, player2, win);
                playerWin[player2]--;
            }
            patternIndex[0]--;
            patternIndex[1]--;
        }
        else {
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                int versusType = playerPattern[player2][patternIndex[player2]];
                patternIndex[player2]++;
                visited[i] = true;
                if (handType[i][versusType] == 2) {
                    doBattle(2, convertNum(player2), win + 1);
                }
                else {
                    playerWin[player2]++;
                    doBattle(0, 1, win);
                    playerWin[player2]--;
                }
                visited[i] = false;
                patternIndex[player2]--;
            }
        }
    }

    public static boolean checkVisited() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }

    public static int convertNum(int n) {
        return n == 1 ? 0 : 1;
    }
}
