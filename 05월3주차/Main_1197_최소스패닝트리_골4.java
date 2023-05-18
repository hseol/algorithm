/**
 * 
 */
package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1197_최소스패닝트리_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 17.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1197_최소스패닝트리_골4 {
	static int parents[], V, E, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V + 1];
		arr = new int[E][3];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		} // 초기화
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
			arr[i][2] = cost;
		}
		Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]);
		for (int i = 0; i < E; i++) {
			if (find(arr[i][0]) != find(arr[i][1])) {// 부모가 같지 않으면~
				union(arr[i][0], arr[i][1]);
				result += arr[i][2];
			}
		}
		System.out.println(result);

	}

	public static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return find(parents[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (x < y) {
			parents[y] = x;
		} else
			parents[x] = y;
		return true;
	}

}
