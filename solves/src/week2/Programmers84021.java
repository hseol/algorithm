package week2;

import java.util.*;

class Programmers84021 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static class Figure {

        List<Pos> posList;

        Figure() {
            this.posList = new ArrayList<>();
        }
    }

    public static class Pos {
        int x;
        int y;

        Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        System.out.println(solution(game_board, table));
    }

    public static int solution(int[][] game_board, int[][] table) {

        List<Figure> figureList = getFigureSet(table, 1);
        List<Figure> targetList = getFigureSet(game_board, 0);
        boolean[] visited = new boolean[figureList.size()];

        recursive(figureList, targetList, visited, 0, 0);
        return answer;
    }

    public static void recursive(List<Figure> figureList, List<Figure> targetList, boolean[] visited, int depth, int temp) {

        if (depth == targetList.size()) {
            if (answer < temp) answer = temp;
            return ;
        }

        Figure target = targetList.get(depth);

        recursive(figureList, targetList, visited, depth + 1, temp);
        for (int i = 0; i < figureList.size(); i++) {
            Figure figure = figureList.get(i);
            if (visited[i]) continue;
            if (figure.posList.size() != target.posList.size()) continue;
            if (!isIntoTarget(target, figure)) continue;
            visited[i] = true;
            recursive(figureList, targetList, visited, depth + 1, temp + figure.posList.size());
            visited[i] = false;
        }
    }

    public static int[][] getBoard(List<Pos> posList) {

        int minx = posList.get(0).x;
        int maxx = posList.get(0).x;
        int miny = posList.get(0).y;
        int maxy = posList.get(0).y;

        for (Pos pos : posList) {
            if (pos.x < minx) minx = pos.x;
            if (pos.x > maxx) maxx = pos.x;
            if (pos.y < miny) miny = pos.y;
            if (pos.y > maxy) maxy = pos.y;
        }

        int n = maxx - minx > maxy - miny ? maxx - minx + 1 : maxy - miny + 1;
        int fixx = minx < 0 ? minx * - 1 : 0;
        int fixy = miny < 0 ? miny * - 1 : 0;

        int[][] board = new int[n][n];

        for (Pos pos : posList) {
            board[pos.x + fixx][pos.y + fixy] = 1;
        }
        return board;
    }

    public static boolean isIntoTarget(Figure target, Figure figure) {

        int[][] targetBoard = getBoard(target.posList);
        int[][] figureBoard = getBoard(figure.posList);

        int n = targetBoard.length;
//        System.out.println("============target==============");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(targetBoard[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("===============================");


        for (int k = 0; k < 4; k++){

            if (k > 0) figureBoard = rotate(figureBoard, n);

//            System.out.println("---------------" + k + "-----------------");
//            for (int a = 0; a < n; a++) {
//                for (int b = 0; b < n; b++) {
//                    System.out.print(figureBoard[a][b] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("-------------------------------------------");

            boolean flag = true;
            loop:
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    if (targetBoard[i][j] != figureBoard[i][j]) {
                        flag = false;
                        break loop;
                    }
                }
            }
//            if (flag) System.out.println("pass!!!!!");
            if (flag) return true;
        }
        return false;
    }

    public static int[][] rotate(int[][] board, int n) {

        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = board[n - 1 - j][i];
            }
        }

        return ret;
    }

    //target : 0이면 game_board (빈칸만 잡기)
    //target : 1이면 table 채워진 칸 찾기
    public static List<Figure> getFigureSet(int[][] board, int target) {

        List<Figure> ret = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    ret.add(getFigure(new Pos(i, j), board, visited, target));
                }
            }
        }

        return ret;
    }

    public static Figure getFigure(Pos pos, int[][] board, boolean[][] visited, int target) {

        Figure ret = new Figure();
        ret.posList.add(new Pos (0, 0));
        Queue<Pos> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;

        visited[pos.x][pos.y] = true;
        q.add(pos);

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] != target) continue;
                q.add (new Pos(nx, ny));
                ret.posList.add(new Pos(nx - pos.x, ny - pos.y));
                visited[nx][ny] = true;
            }
        }

        return ret;
    }
}