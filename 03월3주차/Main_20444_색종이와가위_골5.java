
package BinarySearch;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_20444_색종이와가위_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 18.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_20444_색종이와가위_골5 {
	static int N;
	static long K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		long start = 0;
		long end = N / 2;
		while (start <= end) {
			long first = (start + end) / 2;
			long second = N - first;

			if ((first + 1) * (second + 1) == K) {
				System.out.println("YES");
				return;
			} else if ((first + 1) * (second + 1) < K) {// first올려~
				start = first + 1;
			} else if ((first + 1) * (second + 1) > K) {
				end = first - 1;
			}
		}
		System.out.println("NO");

	}

}

/* 똥망한 코드 아까우니까 올리겠음 */

//		int count = 0;
//		ArrayList<Integer> arr = new ArrayList<>();
//		int first = (N / 2);
//		int second = N - first; // 홀수라면 세컨드가 더 큰 수
//		//long[] check = new long[(int) (first + 1)];
//		//boolean flag = true;
//		while (!arr.contains(first)) {
//			if ((first + 1) * (second + 1) == K) {
//				count++;
//				System.out.println("1");
//				System.out.println(first+" "+second);
//				System.out.println("YES");
//				break;
//			} else if ((first + 1) * (second + 1) < K) {
//				count++;
//				System.out.println("2");
//				System.out.println(first+" "+second);
//				arr.add(first);
//				first++;
//				second--;
//
//			} else if ((first + 1) * (second + 1) > K) {
//				count++;
//				System.out.println("3");
//				System.out.println(first+" "+second);
//				arr.add(first);
//				if(arr.contains(first-1)) {
//					//그 사이 수에 해당하는거니까 
//					break;
//				}
//				first /= 2;
//				second = N - first;
//			}
//		}
//		if (arr.contains(first)) {// 비정상적으로 끝났다면
//			System.out.println("4");
//			System.out.println("NO");
//		}
//		
//		System.out.println("계산 횟수 "+count);
