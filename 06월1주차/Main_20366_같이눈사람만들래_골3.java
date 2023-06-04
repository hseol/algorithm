/**
 * 
 */
package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_20366_같이눈사람만들래_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 4.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_20366_같이눈사람만들래_골3 {
	static int N;
	static int[] snows;
	static int result = Integer.MAX_VALUE;
	static StringBuilder sb;

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		N = Integer.parseInt(br.readLine());
//		snows = new int[N];
//		Elsa = new int[2];
//		check = new boolean[N];
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			snows[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(snows);
//		Combi(0, 0);
//		System.out.println(result);
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		snows = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			snows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snows);
		calcul();
		System.out.println(sb);
	}

	public static void calcul() {
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = i + 3; j < N; j++) { // 두 눈덩이 사이에 최소 2개 이상의 눈덩이가 들어가야 다른 쪽의 눈사람을 만들 수 있다.
				int elsa = snows[i] + snows[j]; // 1번 눈사람 키

				// 2번 눈사람 구성
				int start = i + 1;
				int end = j - 1;
				while (start < end) {
					int anna = snows[start] + snows[end]; // 다른 눈사람 키

					if (elsa == anna) { // 키 차이가 0이면 최소니까 종료
						sb.append(0);
						return;
					} else if (anna > elsa) {
						end--; // 눈사람 키를 줄인다.
					} else if (anna < elsa) {
						start++;
					}
					result = Math.min(result, Math.abs(elsa - anna));
				}
			}
		}
		sb.append(result);
	}

}
