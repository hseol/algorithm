package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기_골5 {
static int cnt,N,M,map[][];
static int[]dr= {-1,0,1,0};
static int[]dc= {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M]; 
		st = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken()); 
		int c = Integer.parseInt(st.nextToken());
		
		//0:북,1: 동, 2: 남, 3: 서
		int d = Integer.parseInt(st.nextToken()); //청소기 보는 방향
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			
			}
			
		}//맵생성완료!!! 
		
		cnt =1; //청소한 방의 개수 자기자리 해야되니까 
		clean(r, c, d);
		System.out.print(cnt); 
	}
	static void clean(int r, int c, int dir) {
		map[r][c] = -1;
		System.out.println("방문한 위치 : ["+r+","+c+"]");
		for(int i =0;i<4;i++) {
			dir =(dir+3)%4; //왼쪽방향으로 보기 
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr>=0 && nr<N && nc>=0 && nc<M &&map[nr][nc]==0) {
				cnt++;
				clean(nr,nc,dir);
				
				return; //안 걸면 뒤로 돌아가서 청소할지두~
			}
		
		}
		
			int back = (dir+2)%4;//반대의 방향으로 해야돼서 +2해준다. 
			int br = r+dr[back];
			int bc = c+dc[back];
			
			if(br>=0 && br<N && bc >=0 &&bc<M &&map[br][bc]!=1) {
				clean(br,bc,dir);
			}
		
	}

}
