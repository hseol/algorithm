/**
 * 
 */
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1939_중량제한_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 17.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1939_중량제한_골3 {
	static int N, M, C, start, end;
	static ArrayList<Island> arr[];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		} // 초기화
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int islandS = Integer.parseInt(st.nextToken());
			int islandE = Integer.parseInt(st.nextToken());
			int mess = Integer.parseInt(st.nextToken());
			max = Math.max(max, mess);
			min = Math.min(min, mess);
			arr[islandS].add(new Island(islandE, mess));
			arr[islandE].add(new Island(islandS, mess));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int result = 0;
		// 입력 끝

		while (min <= max) {
			int mid = (min + max) / 2;
			check = new boolean[N + 1];
			if (BFS(mid)) {
				min = mid + 1;
				result = mid;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(result);

	}

	public static boolean BFS(int mid) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			if (tmp == end)
				return true;
			for (int i = 0; i < arr[tmp].size(); i++) {
				if (arr[tmp].get(i).mess >= mid && !check[arr[tmp].get(i).island]) {
					check[arr[tmp].get(i).island] = true;
					queue.offer(arr[tmp].get(i).island);
				}
			}
		}
		return false;
	}

	public static class Island {
		int island;
		int mess;

		public Island(int island, int mess) {
			this.island = island;
			this.mess = mess;
		}
	}
}
