
package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2630_색종이만들기_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 14.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2630_색종이만들기_실2 {
	static int N, map[][];
	static boolean check[][];
	static int countB = 0, countW = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		jongee(0, N, 0, N);
		bw.write(countW+"\n"+countB);
		bw.flush();
		bw.close();

	}

	public static void jongee(int startR, int endR, int startC, int endC) {
		if (isSame(startR, endR, startC, endC)) {
			if (map[startR][startC] == 1) {
				countB++;
			} else {
				countW++;
			}
			return;
		}

		jongee(startR, (startR + endR) / 2, startC, (startC + endC) / 2);
		jongee(startR, (startR + endR) / 2, (startC + endC) / 2, endC);
		jongee((startR + endR) / 2, endR, startC, (startC + endC) / 2);
		jongee((startR + endR) / 2, endR, (startC + endC) / 2, endC);

	}

	public static boolean isSame(int startR, int endR, int startC, int endC) {
		int color = map[startR][startC];
		for (int i = startR; i < endR; i++) {
			for (int j = startC; j < endC; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

}
