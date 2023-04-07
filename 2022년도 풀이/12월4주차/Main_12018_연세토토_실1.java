package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_12018_연세토토_실1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] minArr = new int[n]; 

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); 
			int L = Integer.parseInt(st.nextToken()); 
			Integer[] mList = new Integer[P];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < P; j++) {
				mList[j] = Integer.parseInt(st.nextToken());
			}
			if (P < L) {
				minArr[i] = 1;
				continue;
			} else {
				Arrays.sort(mList, Collections.reverseOrder());
				minArr[i] = mList[L - 1];
			}
		}

		Arrays.sort(minArr);
		int cnt = 0; 
		int mSum = 0; 
		for (int i = 0; i < n; i++) {
			mSum += minArr[i];
			if (mSum > m) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}