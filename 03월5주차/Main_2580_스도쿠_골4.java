/**
 * 
 */
package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2580_스도쿠_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 28.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 : 11달전에 풀다가 실패한 문제...
 * 
 */
public class Main_2580_스도쿠_골4 {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);
	}

	public static void sudoku(int r, int c) throws IOException {
		if (c == 9) {
			sudoku(r + 1, 0);
			return;
		}
		if (r == 9) {// 탐색 끝
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.write(map[i][j] + " ");
				}
				bw.write('\n');
			}
			bw.flush();
			bw.close();
			System.exit(0);

		}
		if (map[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(r, c, i)) {
					map[r][c] = i;
					sudoku(r, c + 1);
				}
			}
			map[r][c] = 0; // 백트래킹 되돌리기..
			return;
		}
		sudoku(r, c + 1);

	}

	public static boolean check(int r, int c, int value) {
		// boolean[] number = new boolean[10];
		// 가로검사
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == value) {
				return false;
			}

		}
		// 세로검사
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == value) {
				return false;
			}

		}
		// 네모검사
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;
		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

}
