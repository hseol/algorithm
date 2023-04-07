/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1043_거짓말_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */

public class Main_1043_거짓말_골4 {
	static int N, M, count = 0;
	static ArrayList<Integer>[] party;
	static boolean[] truepeople;
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 사람수
		M = Integer.parseInt(st.nextToken()); // 파티수
		truepeople = new boolean[N+ 1];
		parent = new int[N+1];
		for(int i=1;i<=N; i++) {
			parent[i] = i;
		}
		int T; // 진실을 아는 사람
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		if (T == 0) {
			System.out.println(M);
			return;

		}
		while (T-- > 0) {
			truepeople[Integer.parseInt(st.nextToken())] = true;
		}

		ArrayList<Integer>[] party = new ArrayList[M + 1];

		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();
		} // 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 파티 몇명
			int firstperson =Integer.parseInt(st.nextToken());
			party[i].add(firstperson);
			n--;
			while (n-- > 0) {
				int compa= Integer.parseInt(st.nextToken());
				party[i].add(compa); // 파티에 해당하는 사람 넣기
				union(firstperson,compa);//부모 맞춰주기
				
			}
		} // 입력 끝////////////////////////////////////////////////////////////
		
		int parent;
		for(int i=1;i<truepeople.length;i++) {
			if(truepeople[i]) { //진실을 안다면
				truepeople[find(i)]=true; //걔와 관련된 애들도 트루
			}
		}
		for(int i=0;i<M;i++) {
			parent = find(party[i].get(0));
			if(!truepeople[parent])count++;
		}
		System.out.println(count);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return true;
		} else { // 같지않아
			if (x > y) {
				parent[x] = y;
			} else {
				parent[y] = x;

			}
			return true;
		}

	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;

		}
		return find(parent[x]);
	}
}
