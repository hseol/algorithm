package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_24041_성싶당밀키트_골4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 ArrayList<Mealkit> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int so = Integer.parseInt(st.nextToken());
			int da = Integer.parseInt(st.nextToken());
			int ii = Integer.parseInt(st.nextToken());
			if (ii == 1) {
				count++;
			}
			arr.add(new Mealkit(so, da, ii, 0));
		} // 입력 끝

		K = Math.min(K, count);

		// 범위를 정하는 함수
		long mid = 0;
		long result = 0;
		long answer = 0;
		long left = 0, right = 2000000001;
		while (left <= right) {
			result = 0;
			mid = (left + right) / 2;
			for (Mealkit i : arr) {
				i.point = i.sok * Math.max(1, mid - i.date);
			}
			Collections.sort(arr); // 정렬
			System.out.println("mid가 "+mid);
			for (Mealkit i : arr) {
				System.out.println(i.sok+" "+i.date+" "+i.point+" "+i.im);
			}

			for (int i = K; i < arr.size(); i++) {
				result += arr.get(i).point;
			}
			if (result <= G) {// 조건이 되냐
				answer = Math.max(answer, mid);
				left = mid + 1;

			} else {
				right = mid - 1;
			}

			// 계산해주는 함수
		}
		System.out.println(answer);
	}

	static class Mealkit implements Comparable<Mealkit> {
		long sok;
		long date;
		int im;
		long point;

		Mealkit(long sok, long date, int im, long point) {
			this.sok = sok;
			this.date = date;
			this.im = im;
			this.point = point;
		}

		@Override
		public int compareTo(Mealkit o) {
			if (this.im < o.im) {
				return 1;
			} else if (this.im == o.im) {
				if (this.point < o.point) {
					return 1;
				} else if (this.point == o.point) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}

		}
	}


}
