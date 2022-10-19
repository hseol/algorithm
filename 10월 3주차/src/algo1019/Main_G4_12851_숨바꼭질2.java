package algo1019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//22604KB 148ms
public class Main_G4_12851_숨바꼭질2 {
	
	static int N,K,cnt=0,min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N>=K) {
			System.out.println(N-K);
			System.out.println(1);
			return ;
		}
		
		bfs();
		
		System.out.println(min);
		System.out.println(cnt);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int[] move = new int[100001];
		q.offer(N);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(min<move[cur]) return ;
			if(move[cur]<=min && cur==K) {
				min=move[cur];
				cnt++;
			}
			
			for(int i=0; i<3; i++) {
				int next = cur;
				switch(i) {
				case 0 : 
					next = cur - 1;
					break;
				case 1 :
					next = cur + 1;
					break;
				case 2 :
					next = cur * 2;
					break;
				}
				
				if(next>=0 && next<=100000) {
					if(move[next]==0 || move[next]>=move[cur]+1) {
						move[next] = move[cur]+1;
						q.offer(next);
					}
				}
			}
		}
	}
}
