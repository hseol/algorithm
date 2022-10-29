package algo1025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_퍼즐조각채우기 {
	
	int[] dr = {-1,0,1,0};
	int[] dc = {0,1,0,-1};
	
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        
        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<List<int[]>> tableList = new ArrayList<>();
        List<List<int[]>> boardList = new ArrayList<>();
        
        for(int i=0; i<table.length; i++) {
        	for(int j=0; j<table.length; j++) {
        		if(table[i][j]==1 && !visitedTable[i][j]) {
        			bfs(i, j, visitedTable, table, 1, tableList);
        		}
        		
        		if(game_board[i][j]==0 && !visitedBoard[i][j]) {
        			bfs(i,j,visitedBoard, game_board, 0, boardList);
        		}
        	}
        }
        
        answer = findBlock(boardList, tableList);
        
        return answer;
    }
    
    public int findBlock(List<List<int[]>> boardList, List<List<int[]>> tableList){
        int size = 0;
        int tableLen = tableList.size();
        int boardLen = boardList.size();
        boolean[] visitedBoard = new boolean[boardLen];
        for (int i = 0; i < tableLen; i++){
            List<int[]> tablePoints = tableList.get(i);
            for (int j = 0; j < boardLen; j++){
                List<int[]> boardPoints = boardList.get(j);

                if (tablePoints.size() == boardPoints.size() && !visitedBoard[j]){ //좌표 개수 같을때
                    if(isRotate(boardPoints, tablePoints)){ //회전해서 맞는지 확인
                        size += tablePoints.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }

        }

        return size;
    }
    
    public boolean isRotate(List<int[]> board, List<int[]> table){
        boolean isCollect = false;

        board.sort((o1, o2) -> {
            return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < 4; i++){ //table퍼즐 0, 90, 180, 270도 회전

            table.sort((o1, o2) -> {
                return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
            });
            int nearZeroX = table.get(0)[0];
            int nearZeroY = table.get(0)[1];

            for (int j = 0; j < table.size(); j++){
                table.get(j)[0] -= nearZeroX;
                table.get(j)[1] -= nearZeroY;
            }


            boolean isCollectPoint = true;
            for (int j = 0; j < board.size(); j++){ //좌표 비교
                int[] boardPoint = board.get(j);
                int[] tablePoint = table.get(j);

                if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]){
                    isCollectPoint = false;
                    break;
                }
            }

            if (isCollectPoint){
                isCollect = true;
                break;
            } else{ //90도 회전 : x,y -> y, -x
                for(int j = 0; j < table.size(); j++){
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }
        return isCollect;

    }

    public void bfs(int cr, int cc, boolean[][] visited, int[][] graph, int blockOrEmpty, List<List<int[]>> list){
        Queue<int[]> queue = new LinkedList<>();
        visited[cr][cc] = true;
        queue.add(new int[]{cr, cc});
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0,0});

        while (!queue.isEmpty()){
            int[] pop = queue.remove();
            int r = pop[0];
            int c = pop[1];

            for (int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= graph.length || nc < 0 || nc >= graph.length){
                    continue;
                }
                if (!visited[nr][nc] && graph[nr][nc] == blockOrEmpty){

                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                    subList.add(new int[]{nr-cr, nc-cc});
                }
            }
        }
        list.add(subList);
    }
}