package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_3020_개똥벌레_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 22.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_3020_개똥벌레_골5 {
	static int N, H, mite[], tite[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		mite = new int[N / 2]; // stalagmite 가 석순이래 호옹
		tite = new int[N / 2]; // stalactite 는 종유석이래~
		int result = Integer.MAX_VALUE;
		int count = 0;
		int index = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				mite[index] = tmp;
			} else {
				tite[index] = H + 1 - tmp;
				index++;
			}
		} // 입력끝

		Arrays.sort(mite);
		Arrays.sort(tite);

		for (int i = 1; i <= H; i++) {

			int tmp = smite(i) + stite(i);
			if (tmp == result) {
				count++;
			} else if (tmp < result) {
				result = tmp;
				count = 1;
			}
		}
		System.out.println(result+" "+count);

	}

	public static int smite(int target) {
		int start = 0, end = mite.length;

		while (start < end) {
			int mid = (start + end) / 2;
			if (target <= mite[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return mite.length - start;
	}

	public static int stite(int target) {
		int start = 0, end = tite.length;

		while (start < end) {
			int mid = (start + end) / 2;
			if (target < tite[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}
		return start;
	}

}

/*원래 분류가 이분탐색과 누적합인데 이걸 석순 종유석으로 나눠서 누적합으로 해서 같은 걸 세어주는 방법이 있었군*/
