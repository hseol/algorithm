/**
 * 
 */
package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_2447_별찍기10_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 2.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2447_별찍기10_골5 {
	static int N;
	static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		star(0, 0, N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] != null ? arr[i][j] : " ");
			}sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void star(int startR, int startC, int n) {
		if (n == 1) {
			arr[startR][startC] = "*";
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) {
					// 빈칸아니면
					star(startR + i * n / 3, startC + j * n / 3, n / 3);
				}

			}
		}

	}

}
