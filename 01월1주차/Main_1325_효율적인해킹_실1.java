package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹_실1 {
	static int N, M, count[];
	static boolean[] check;
	static int result = 0, temp;
	static ArrayList<Integer> map[];
	static int res[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String answer = "";
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];
		res = new int[N+1];

		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A].add(B);
		} // 입력 끝

		for (int i = 1; i <= N; i++) {// 첫 출발지 돌리기
			check = new boolean[N + 1];
			hacking(i);
			//temp = Math.max(temp, count[i]);// 돌면서 최대값이라고 생각하는거

		}
		int max=0;
		for(int i =1;i<=N;i++) {
			if(max<res[i]) {
				max=res[i];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (res[i] == max) {
				System.out.print(i + " ");
			}
		}
	}

	public static void hacking(int start) {
		check[start] = true;
		for (int s : map[start]) {
			if (!check[s]) {
				hacking(s);
				res[s]++;
			}
		}

	}
}

/*
 * 인접행렬인접리스트.. 로 풀어야만 풀리는 문제였다.. ㅅㅂ 시간초과 짱나네
 */
