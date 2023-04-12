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
 * @FileName : Main_5567_결혼식.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 13.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_5567_결혼식_실2 {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		check = new boolean[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
			arr[end].add(start);
		} // 입력 끝
		check[1] = true;
		for (int i = 0; i < arr[1].size(); i++) {
			findFriend(arr[1].get(i), 0);
		}

		for (int i = 2; i <= N; i++) {
			if (check[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void findFriend(int num, int depth) {
		if (depth == 2) {
			return;
		}
		check[num] = true;
		for (int i = 0; i < arr[num].size(); i++) {
			if (check[arr[num].get(i)])
				continue;
			findFriend(arr[num].get(i), depth + 1);
		}
		return;

	}
}
