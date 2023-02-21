/**
 * 
 */
package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_17406_배열돌리기4_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 21.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_17406_배열돌리기4_골5 {
	static int N, M, K, map[][], spin[][], order[];
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		order = new int[K];
		isSelected = new boolean[K + 1];
		spin = new int[K + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				spin[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		Order(0);
		System.out.println(answer);

	}

	/*배열 돌려주는 함수*/
	public static void bingle() {
		int[][] test = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				test[i][j] = map[i][j];
			}
		} //배열 복사해주기! 
		
		/* order 대로 돌려주기*/
		for (int s = 0; s < K; s++) {
			int siz = spin[order[s]][2] * 2; // 행렬 사이즈
			for (int q = 0; q < siz; q += 2) { //행렬 크기가 1*1될때까지 돌려주기 
				int checking = siz - q;
				if (checking <= 1)
					break;

				int startR = spin[order[s]][0] - spin[order[s]][2] + (q / 2);// 돌릴 행렬 첫 행;
				int startC = spin[order[s]][1] - spin[order[s]][2] + (q / 2);// 돌릴 행렬 첫 열;

				int endR = spin[order[s]][0] + spin[order[s]][2] - (q / 2);// 돌릴 행렬 끝 행;
				int endC = spin[order[s]][1] + spin[order[s]][2] - (q / 2);// 돌릴 행렬 끝 열;

				int tmp = test[startR][startC]; //가지고 있다가 마지막에 쏙 넣어줄 아이 
				
				for (int i = startR; i < startR + checking; i++) {
					// 위
					test[i][startC] = test[i + 1][startC];
				}
				for (int j = startC; j < startC + checking; j++) {
					// 왼아래
					test[endR][j] = test[endR][j + 1];
				}
				for (int i = startR + checking; i >= startR + 1; i--) {
					// 아래
					test[i][endC] = test[i - 1][endC];
				}

				for (int j = startC + checking; j >= startC + 1; j--) {
					// 오른위
					test[startR][j] = test[startR][j - 1];
				}
				test[startR][startC + 1] = tmp;

//				System.out.println("====================출력=====================");
//				for (int i = 0; i <= N; i++) {
//					for (int j = 0; j <= M; j++) {
//						System.out.print(test[i][j] + " ");
//					}
//					System.out.println();
//				}
			}

		}
		for (int i = 1; i <= N; i++) {
			int result = 0;
			for (int j = 1; j <= M; j++) {
				result += test[i][j]; // 행 별 합계
			}
			answer = Math.min(result, answer); // 그 행렬의 값
		}

	}

	static int answer = Integer.MAX_VALUE;

	public static void Order(int cnt) { //순열로 배열 만들어주기 백트래킹... 인가...?
		if (cnt == K) {
			bingle();
			return;
		}
		for (int i = 1; i <= K; i++) {
			if (isSelected[i])
				continue;
			order[cnt] = i;
			isSelected[i] = true;
			Order(cnt + 1);
			isSelected[i] = false;

		}
	}
}
