/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1003_피보나치함수_실3_두번째시도.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 9.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 이전에는 2차원배열을 이용하여 범위가 40인것을 고려해서 메모이제이션으로 다 구한다음 입력에 맞게 출력함 
 * 이번에는 리스트배열을 사용해서 들어오는 값이 존재하면 출력 아니면 새로 만들어주는 식으로 했음 
 * 메모리가 좀더 절약됨 
 * 
 */
public class Main_1003_피보나치함수_실3_두번째시도 {
	// static ZeroOne[] arr;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		list.add(new int[] { 1, 0 }); // 0
		list.add(new int[] { 0, 1 }); // 1
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			if (N >= 2) {
				for (int i = 2; i <= N; i++) {
					if (list.size() > i) { // 이미 등록되어있는 애들이 있을때
						continue;
					} else {// 내가 새로 추가해야할때
						int zero = list.get(i - 1)[0] + list.get(i - 2)[0];
						int one = list.get(i - 1)[1] + list.get(i - 2)[1];
						list.add(new int[] { zero, one });
					}
				}

			}
			sb.append(list.get(N)[0]).append(" ").append(list.get(N)[1]).append("\n");

		}
		System.out.println(sb);

//		while (T-- > 0) {
//			int N = Integer.parseInt(br.readLine());
//			arr = new ZeroOne[N + 1];
//			for (int i = 0; i <= N; i++) {
//				arr[i] = new ZeroOne(0, 0);
//			}
//			arr[0].one = 0;
//			arr[0].zero = 1;
//
//			if (N >= 1) {
//				calcul(N);
//			}
//			System.out.println(arr[N].zero + " " + arr[N].one);
//		}

	}

//	public static class ZeroOne {
//		int zero;
//		int one;
//
//		public ZeroOne(int zero, int one) {
//			this.zero = zero;
//			this.one = one;
//
//		}
//	}
//
//	public static void calcul(int N) {
//		arr[1].one = 1;
//		arr[1].zero = 0;
//		if (N == 1)
//			return;
//		for (int i = 2; i <= N; i++) {
//			arr[i].one = arr[i - 1].one + arr[i - 2].one;
//			arr[i].zero = arr[i - 1].zero + arr[i - 2].zero;
//		}
//
//	}

}
