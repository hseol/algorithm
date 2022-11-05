package algo1101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//16560KB 156ms
public class Main_S1_3184_양 {
	
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='v' && !visited[i][j]) {
					visited[i][j]=true;
					bfs(i, j);
				}
			}
		}
		
		int sheep=0;
		int wolf=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='o') sheep++;
				if(map[i][j]=='v') wolf++;
			}
		}
		System.out.println(sheep + " " + wolf);
	}
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void bfs(int r, int c) {
		List<int[]> sheep = new ArrayList<>();
		List<int[]> wolf = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			if(map[cr][cc]=='o') sheep.add(new int[] {cr,cc});
			if(map[cr][cc]=='v') wolf.add(new int[] {cr,cc});
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc] || map[nr][nc]=='#') continue;
				
				visited[nr][nc]=true;
				q.offer(new int[] {nr,nc});
			}
		}

		if(sheep.size()>wolf.size()) {
			for(int[] point : wolf) {
				map[point[0]][point[1]]='.';
			}
		} else {
			for(int[] point : sheep) {
				map[point[0]][point[1]]='.';
			}
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
