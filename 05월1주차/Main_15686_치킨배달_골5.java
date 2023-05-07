
package BruteForcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_15686_치킨배달_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 7.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_15686_치킨배달_골5 {
	static int N, M;
	static boolean check[];
	static List<Node> chicken, house;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		house = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					chicken.add(new Node(i, j));
				} else if (num == 1) {
					house.add(new Node(i, j));
				}
			}
		} // 입력 끝
		check = new boolean[chicken.size()];
		store(0, 0);
		System.out.println(result);
	}

	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void store(int start, int cnt) {
		if (cnt == M) {// M개 배치 끝
			// 치킨 거리 구하는 함수
			result = Math.min(result, distance());
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			check[i] = true;
			store(i + 1, cnt + 1);
			check[i] = false;
		}
	}

	public static int distance() {
		int cityDis = 0;
		for (Node ho : house) {
			int dis = Integer.MAX_VALUE;
			for (int i = 0; i < chicken.size(); i++) {
				if (check[i]) {
					int tmp = Math.abs(ho.r - chicken.get(i).r) + Math.abs(ho.c - chicken.get(i).c);
					dis = Math.min(dis, tmp); // 각 집의 치킨거리
				}
			}
			cityDis += dis;
		}
		return cityDis;
	}

}
