/**
 * 
 */
package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_21608_상어초등학교_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 1.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_21608_상어초등학교_골5 {
	static int N, map[][], total,order[];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Integer>[] Flist;
	static PriorityQueue<Loca> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		total = N * N;
		map = new int[N + 1][N + 1];
		order = new int[total];
		Flist = new ArrayList[total + 1];
		for (int i = 0; i <= total; i++) {
			Flist[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			order[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				Flist[order[i]].add(Integer.parseInt(st.nextToken()));
			}
		} // 입력끝
		for (int i = 0; i < total; i++) {
			int stu = order[i];
			// System.out.println(stu + "번 학생이 앉을차례");
			like(stu);
			pq.clear();

		}
		happy();

	}

	public static void like(int stu) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0)
					continue;
				int likepoint = 0;
				int vacantpoint = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr <= 0 || nc <= 0 || nr > N || nc > N)
						continue;
					if (Flist[stu].contains(map[nr][nc])) { // 탐색위치 4방에 내가 좋아하는애가 있나요?
						likepoint++;
					}
					if (map[nr][nc] == 0) {
						vacantpoint++;
					}
				}
				// System.out.println(i+" "+j+" "+likepoint+" "+vacantpoint);
				pq.add(new Loca(i, j, likepoint, vacantpoint));
				// System.out.println("joa:" + joa);
				// check[i][j] = joa;

			}
		}
//		System.out.println("실행결과1 : ======================================");
//		for (int[] a : arr) {
//			System.out.println("후보" + a[0] + " " + a[1]);
//		}
		Loca loca = pq.poll();
		// System.out.println("나온친구~"+loca.r+" "+loca.c);
		map[loca.r][loca.c] = stu;

	}

//	public static void vacant(int stu) {
//
//		if (arr.isEmpty()) {
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					int vac = 0;
//					for (int d = 0; d < 4; d++) {
//						int nr = i + dr[d];
//						int nc = j + dc[d];
//						if (nr <= 0 || nc <= 0 || nr > N || nc > N || map[nr][nc] != 0)
//							continue;
//						vac++;
//					}
//					// System.out.println(i + " " + j + "일때 vac값" + vac);
//					pq.add(new Loca(i, j, vac));
//				}
//
//			}
//			// 비었으면 우선순위가 하나도 없단 소리 (빈자리)
//		} else { // 하나라도 있으면 걔 우선으로 하고 탐색시작
//			// System.out.println("어레이 안비엇어");
////			for (int[] a : arr) {
////				System.out.println("어레이안에는" + a[0] + " " + a[1]);
////			}
//			for (int i = 0; i < arr.size(); i++) {
//				int vac = 0;
//				for (int d = 0; d < 4; d++) {
//					int nr = arr.get(i)[0] + dr[d];
//					int nc = arr.get(i)[1] + dc[d];
//					if (nr <= 0 || nc <= 0 || nr > N || nc > N || map[nr][nc] != 0)
//						continue;
//					vac++;
//				}
//				// System.out.println("vac값" + vac);
//				pq.add(new Loca(arr.get(i)[0], arr.get(i)[1], vac));
//			}
//		}
//		// 피큐에 다 정렬되었다면
//		Loca loca = pq.poll();
//		// System.out.println(loca.r + " " + loca.c);
//		map[loca.r][loca.c] = stu;
//		arr.clear();
////		System.out.println("실행결과2 : ======================================");
////		for (int i = 1; i <= N; i++) {
////			for (int j = 1; j <= N; j++) {
////				System.out.print(map[i][j] + " ");
////			}
////			System.out.println();
////		}
//	}

	public static void happy() {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int joa = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr <= 0 || nc <= 0 || nr > N || nc > N)
						continue;
					if (Flist[map[i][j]].contains(map[nr][nc])) {
						joa++;
					}
				}
				if (joa != 0) {
					result += (int) Math.pow(10, joa - 1);
				}
			}

		}
		System.out.println(result);
	}

	public static class Loca implements Comparable<Loca> {
		int r;
		int c;
		int likepoint;
		int vacantpoint;

		public Loca(int r, int c, int likepoint, int vacantpoint) {
			this.r = r;
			this.c = c;
			this.likepoint = likepoint;
			this.vacantpoint = vacantpoint;
		}

		@Override
		public int compareTo(Loca o) {
			// 공백이 가장 많은 순
			// 행이 작은거
			// 열이 작은거
			if (o.likepoint > this.likepoint) {
				return 1;
			} else if (o.likepoint == this.likepoint) {
				if (o.vacantpoint > this.vacantpoint) {
					return 1;
				} else if (o.vacantpoint == this.vacantpoint) {
					if (o.r < this.r) {
						return 1;
					} else if (this.r == o.r) {
						if (o.c < this.c) {
							return 1;
						} else if (o.c == this.c) {
							return 0;
						} else {
							return -1;
						}
					} else
						return -1;
				} else {
					return -1;
				}
			} else {
				return -1;
			}

		}
	}

}
