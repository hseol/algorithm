
package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName : Main_5052_전화번호목록_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 15.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_5052_전화번호목록_골5 {
	static int T, N;
	static String tele[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			tele = new String[N];
			for (int i = 0; i < N; i++) {
				tele[i] = br.readLine();
			}
			Arrays.sort(tele);
			isRight(tele);

		}

	}

	public static void isRight(String[] tele) {
		for (int i = 0; i < N - 1; i++) {
			if (tele[i + 1].startsWith(tele[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}
}

/* 문자열비교도 해주는 라이브러리가 있네... 쩝 */
