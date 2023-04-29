/**
 * 
 */
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2457_공주님의정원_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 27.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2457_공주님의정원_골3 {
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Flower> arr = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startDate = Integer.parseInt(st.nextToken()) * 100+Integer.parseInt(st.nextToken());
			int endDate =Integer.parseInt(st.nextToken()) * 100+Integer.parseInt(st.nextToken());
			arr.add(new Flower(startDate, endDate));
		}//입력끝 
		
		Collections.sort(arr);
		int start = 301;
		int end = 1201;
		int tmp = 0;
		int count = 0;
		int index=0;
		boolean isNew = false;
		
		while (start < end) {
			isNew = false;
			for (int i = index; i < arr.size(); i++) {
				if (arr.get(i).start > start) {
					break;// 시작 날짜가 start보다 크면 멈춰
				}

				if (tmp <= arr.get(i).end) {
					tmp = arr.get(i).end;
					index++; //시간초과 원인
					isNew = true;

				}

			}
			if (isNew) {
				start = tmp;
				count++;
			} else {
				break; // 날짜에 공백이 생김
			}
		}
		if (tmp < end) { // 공백이 생겨버려서 끝났는데 제일 긴 날짜가 end 에 도달하지못함
			System.out.println(0);

		} else {
			System.out.println(count);
		}

	}

	public static class Flower implements Comparable<Flower> {
		int start;
		int end;

		public Flower(int start, int end) {
			this.start = start;
			this.end = end;

		}

		public int compareTo(Flower o) {
			if (this.start == o.start) {
				return o.end - this.end;
			} else {
				return this.start - o.start;
			}
		}
	}

}
