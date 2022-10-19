package algo1019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//16332KB 92ms
public class Main_G4_14226_이모티콘 {
	
	static int S, res;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[2001][2001];
		
		res=0;
		bfs();
		System.out.println(res);
	}
	
	public static void bfs() {
		Queue<Emoji> q = new LinkedList<>();
		q.offer(new Emoji(1, 0, 0));
		visited[1][0]=true;
		
		while(!q.isEmpty()) {
			Emoji cur = q.poll();
			if(cur.screen==S) {
				res=cur.time;
				break;
			}
			
			//붙여넣기
			if(cur.clipboard!=0 && !visited[cur.screen+cur.clipboard][cur.clipboard] && cur.screen+cur.clipboard <= 1000) {
				visited[cur.screen+cur.clipboard][cur.clipboard] = true;
				q.offer(new Emoji(cur.screen+cur.clipboard, cur.clipboard, cur.time+1));
			}
			
			//복사
			if(cur.screen!=cur.clipboard && !visited[cur.screen][cur.screen]) {
				visited[cur.screen][cur.screen]=true;
				q.offer(new Emoji(cur.screen, cur.screen, cur.time+1));
			}
			
			//화면이모티콘 1개삭제
			if(cur.screen>0 && !visited[cur.screen-1][cur.clipboard]) {
				visited[cur.screen-1][cur.clipboard]=true;
				q.offer(new Emoji(cur.screen-1, cur.clipboard, cur.time+1));
			}
		}
		
	}
	
	static class Emoji {
		int screen;
		int clipboard;
		int time; 
		public Emoji(int screen, int clipboard, int time) {
			this.screen = screen;
			this.clipboard = clipboard;
			this.time = time;
		}
	}
}
