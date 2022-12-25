package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7983_내일할거야_골5 {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		Homework[] homework = new Homework[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			homework[i] = new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(homework);// t 역순으로 정렬됐으면 좋겠다.
		int end = homework[0].t;
		for (int i = 0; i < n; i++) {
			end = end - homework[i].d;
			if (i == n - 1) {
				System.out.println(end);
				break;
			}
			if (end > homework[i + 1].t) {
				end = homework[i + 1].t;
			}

//			for (int j = arr.get(i).t; arr.get(i).d > 0; j--) {
//				if (day[j]) {// 이미 자리가 있으면
//					continue;
//				}
//				day[j] = true;
//				arr.get(i).d--;
//			}

		}

//		for (int i = 0; i < arr.get(0).t + 1; i++) {
//			if (day[i]) {// 트루를 만나면 그 전까지 세던거 비교해서 넣어주기
//				result = Math.max(result, count);
//				count = 0;
//				continue;
//			} else {
//				count++;
//
//			}
//		}
//		System.out.println(result);

	}

	static class Homework implements Comparable<Homework> {
		public int d;
		public int t;

		public Homework(int d, int t) {
			this.d = d;
			this.t = t;

		}

		@Override
		public int compareTo(Homework o) {
			// TODO Auto-generated method stub
			return o.t - this.t;
		}
	}
}

//난 처음에 최대일수를 체크해야된다고 해서 불린배열을 체크에서 연속적으로 하는 일수를 체크했었음 
//그리고 이중포문해서.. 메모리 초과 ㅋ ㅅㅂ ㅠㅠ 
//찾아보니 인덱스를 저장하여 하는 방법을 사용하게됨

//2차시도
//근데 그게 문제가 아니라 처음에 객체 저장하는거에서 문제였음.. 
//어레이리스트에 객체를 넣는게 아니라 애초에 객체배열을 만들 수 있었는데 까먹고있었음.. 
//객체큐랑 헷갈린지도.. 흑.. 
