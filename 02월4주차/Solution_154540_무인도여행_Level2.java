/**
 * 
 */
package DFS;

/**

  * @FileName : Solution_무인도여행_Level2.java

  * @Project : NewAlgo

  * @Date : 2023. 2. 26. 

  * @작성자 : hseol

  * @변경이력 :

  * @프로그램 설명 :

  */
import java.lang.String;
import java.util.ArrayList;
import java.lang.Character;
import java.util.Collections;
class Solution {
    static boolean[][] visited;
    static int N,M,result;
    static char[][] land;
    public int[] solution(String[] maps) {
        int[] answer;
        N = maps.length;
        M = maps[0].length();
        ArrayList<Integer> arr = new ArrayList<>();
        visited = new boolean[N][M];
        land = new char[N][M];
        for(int i=0;i<N;i++){
            land[i] = maps[i].toCharArray();
        }
    
        
        //출력
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                      if(land[i][j]!='X' &&!visited[i][j]){//숫자고 방문하지 않았음 
                          result = 0;
                          check(i,j);
                          arr.add(result);
                      }
                    }
            
        }
    
        if(arr.size()==0){
        answer = new int[1];
            answer[0]=-1;
        }else{
            Collections.sort(arr);
            answer = new int[arr.size()];
            for(int i=0;i<arr.size();i++){
                answer[i] = arr.get(i);
            }
        }
        return answer;
    }
    public static void check(int r, int c){
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        visited[r][c] = true;
        result+=Character.getNumericValue(land[r][c]);
        for(int d = 0;d<4;d++){
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(nr<0||nc<0||nr>=N||nc>=M||visited[nr][nc]||land[nr][nc]=='X')continue;
            visited[nr][nc] = true;
            check(nr,nc);
             
        }return;
        
    }
}
