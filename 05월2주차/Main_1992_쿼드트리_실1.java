/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1992_쿼드트리_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 11.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1992_쿼드트리_실1 {

	static int N;
	static char map[][];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		} // 입력 끝
		check(0, 0, N);
		System.out.println(sb);

	}

	public static void check(int startR, int startC, int size) {
		if (isSame(startR, startC, size)) {
			sb.append(map[startR][startC]);
		} else {
			size = size / 2;
			sb.append("(");
			check(startR, startC, size);// 위왼쪽
			check(startR, startC + size, size);// 위오른쪽
			check(startR + size, startC, size); // 아래왼쪽
			check(startR + size, startC + size, size);// 아래오른쪽
			sb.append(")");
		}
	}

	public static boolean isSame(int startR, int startC, int size) {
		char color = map[startR][startC];
		for (int i = startR; i < startR + size; i++) {
			for (int j = startC; j < startC + size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

}
