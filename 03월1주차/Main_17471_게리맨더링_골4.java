/**
 * 
 */
package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17471_게리맨더링_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 5.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */

public class Main_17471_게리맨더링_골4 {
	static int N,man[], result = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		man = new int[N + 1];
		arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			man[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= temp; j++) {
				int index = Integer.parseInt(st.nextToken());
				arr.get(i).add(index);
			}
		} // 입력 끝

//		System.out.println("출력-------------------------");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 0; j < arr.get(i).size(); j++) {
//				System.out.print(arr.get(i).get(j) + " ");
//
//			}
//			System.out.println();
//		}
//		System.out.println("-------------------------");
		ArrayList<Integer> first = new ArrayList<>();
		for (int i = 1; i <= N / 2; i++) {// 선택할 원소개수
			Combi(1, N, i, first);
		}
		if(result ==Integer.MAX_VALUE) {
			result =-1;
		}
		System.out.println(result);
		
	}// 메인 끝

	public static void Combi(int start, int n, int r, ArrayList<Integer> first) {
		if (r == 0) {
			Calcul(first);
			return;
		}
		for (int i = start; i <= n; i++) {
			first.add(i);// 선택
			Combi(i + 1, n, r - 1, first);
			first.remove(first.size() - 1);// 비선택
			// 리스트를 이용해서 그냥 조합방식으로 해도 되는듯?
		}
	}

	public static void Calcul(ArrayList<Integer> first) {
		boolean check[]=new boolean[N+1];
		// 인구수 차이 계산하는
		int sumFirst = 0, sumSecond = 0;
		ArrayList<Integer> second = new ArrayList<>();
		if (isLinked(first)) { // 첫번째 구역이 서로 인접해있나요?
			for (int i : first) {
				sumFirst += man[i];
				check[i] = true;
			}
			for (int i = 1; i <= N; i++) {
				if (!check[i]) {
					second.add(i);
				}
			}
			if (isLinked(second)) {// 둘다 연결이 잘 되어있네
				for (int i : second) {
					sumSecond += man[i];
				}
				result = Math.min(result, Math.abs(sumFirst - sumSecond));
			}
			else {
				return;
			}

		}else {
			return;
		}

	}

	public static boolean isLinked(ArrayList<Integer> first) {
		// 선택한 원소들이 이어져 있는지 확인하는
		boolean[] visited = new boolean[N + 1];
		int start = first.get(0);
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		int count = 1;
		while (!queue.isEmpty()) {
			int point = queue.poll();

			for (int i : arr.get(point)) { // point지점에 인접한 원소를 탐색하고 그원소가 다시 내가 고른 구역에 있는지
				if (!visited[i] && first.contains(i)) {
					visited[i] = true;
					count++;
					queue.offer(i);
				}

			}
		}
		if (count == first.size()) {// 그래서 개수가 같다면
			return true;
		}
		return false;

	}
}
