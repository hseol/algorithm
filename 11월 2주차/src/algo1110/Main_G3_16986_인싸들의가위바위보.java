package algo1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//38136KB 264ms
public class Main_G3_16986_인싸들의가위바위보 {
	static int N,K;
	static int[][] map, player;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		player = new int[4][21];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=20; i++) {
			player[2][i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=20; i++) {
			player[3][i]=Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N+1];
		perm(1);
		System.out.println(flag? "1" : "0");
	}

	static void perm(int cnt) {
		if(flag) return;
		if(cnt==N+1) {
			if(game()) flag=true;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			player[1][cnt]=i;
			perm(cnt+1);
			visited[i]=false;
		}
	}
	
	static boolean game() {
		int[] win = new int[4];
		int[] actionIdx = new int[4];
		Arrays.fill(actionIdx, 1);
		
		int player1=1, player2=2, next=3;
		
		while(true) {
			next = 6-player1-player2;
			if(win[1]==K) return true;
			if(win[2]==K || win[3]==K) return false;
			if(actionIdx[1]==N+1 || actionIdx[2]==21 || actionIdx[3]==21) return false;
			
			int winner = whoWin(player1, player2, actionIdx);
			win[winner]++;
			actionIdx[player1]++;
			actionIdx[player2]++;
			
			player1=winner;
			player2=next;
		}
	}
	
	static int whoWin(int p1, int p2, int[] actionIdx) {
		int action1 = player[p1][actionIdx[p1]];
		int action2 = player[p2][actionIdx[p2]];
		
		if(map[action1][action2]==2) return p1;
		else if(map[action1][action2]==1) return Math.max(p1, p2);
		else return p2;
	}
}
