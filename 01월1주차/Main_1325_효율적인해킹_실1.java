package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹_실1{
	static int N, M;
	static boolean[] check;

	static int res[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] map = new ArrayList[N + 1];
		res = new int[N+1];
		check = new boolean[N + 1];

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
			hacking(map,i);
			Arrays.fill(check, false);

		}
		int max=0;
		for(int i =1;i<=N;i++) {
			max=Math.max(max, res[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (res[i] == max) {
				System.out.print(i + " ");
			}
		}
	}

	public static void hacking(ArrayList<Integer>[] map,int start) {
		check[start] = true;
		for (int s : map[start]) {
			if (!check[s]) {
				check[s]=true;
				res[s]++;
				hacking(map,s);
				
			}
		}

	}
}

/*
 * 인접리스트.. 로 풀어야만 풀리는 문제였다..시간초과 짱나네
 * 하지만.. 그게 문제가 아니였음... 
 * 1. 방문하지 않은거에서 들어갈때 방문체크 해주기(이거 제일큼 방문했던것도 한번 더 체크하기 때문에)
 * 2. 새로 방문배열을 만드는 것보다 Arrays.fill(check,false);하는게 훨씬 빠르고 메모리 적게든다.. (새로운사실)
 * 3. 이건 확실하지 않은데 커다란 친구는 static해주는것보단 함수에서 들고다니는게 더 메모리 적게드는듯.. 
 * + 같은 코드를 돌렸는데 시간초과가 나는 아이러니함.. 이딴걸 문제라고.. 
 */
