package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_2178_미로탐색_실1 {
	static int N, M,result;
	static char map[][];
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		bfs(0,0);
		System.out.println(result);

	}

	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int cr,cc,lo;
		result=Integer.MAX_VALUE;
		queue.offer(new int[] {0,0,1});
		check[0][0]=true;
		while (!queue.isEmpty()) {
			int [] loca = queue.poll();
			cr = loca[0];
			cc = loca[1];
			lo = loca[2];//건너간거 카운트
			if(cr==N-1&&cc==M-1) { //끝까지 도달한다면
				result = Math.min(result,lo);
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc+ dc[d];
				if(nr<0||nc<0||nr>=N||nc>=M||check[nr][nc]||map[nr][nc]=='0')continue;
				check[nr][nc]=true;
				queue.offer(new int[] {nr,nc,lo+1});
				
			}
		}

	}
}
