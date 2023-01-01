package BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_골5 {
	static class Location {
		int r;
		int c;

		Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;
	static ArrayList<Location> house;
	static ArrayList<Location> chicken;
	static boolean[] chosen;
	static int city = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		house = new ArrayList<Location>();
		chicken = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					// 집 리스트
					house.add(new Location(i, j));
				}
				if (map[i][j] == 2) {
					// 치킨집 리스트
					chicken.add(new Location(i, j));
				}
			}
		} // 입력끝
		chosen = new boolean[chicken.size()];

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		} // 입력끝

		combi(0, 0);
		System.out.println(city);

	}///// 메인끝

	public static void combi(int start, int cnt) {
		if (cnt == M) {
			// 치킨집을 골랐다
			countDis();
			city = Math.min(city, result);
			return;

		}
		for (int i = start; i < chicken.size(); i++) {
			chosen[i] = true;
			combi(i + 1, cnt + 1);
			chosen[i] = false;
		}
	}

	static int result;

	static public void countDis() {
		result = 0;

		for (int i = 0; i < house.size(); i++) {
			int dis = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.size(); j++) {
				
				if (chosen[j]) {// 선택된 치킨집이면
					// 한 집에 대한 치킨거리
					dis = Math.min(dis,Math.abs(chicken.get(j).r - house.get(i).r) + Math.abs(chicken.get(j).c - house.get(i).c));
				}

			}
			result += dis;
		}

		// result는 이 골라낸 치킨집들에서의 도시 치킨거리
	}

}
