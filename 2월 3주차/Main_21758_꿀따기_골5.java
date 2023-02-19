/**
 * 
 */
package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_21758_꿀따기_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 19.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_21758_꿀따기_골5 {
	static int N, space[], Tobe[], honey, sum[], answer = 0;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		space = new int[N + 1];
		sum = new int[N + 1];
		visited = new boolean[N + 1];
		Tobe = new int[2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			space[i] = Integer.parseInt(st.nextToken());

		} // 입력끝
		sum[1] = space[1];
		for (int i = 2; i <= N; i++) {
			sum[i] = sum[i - 1] + space[i];
			// System.out.println(sum[i-1]);
		} // 누적합

//		for(int i =N;i>=1;i--) {
//			visited[i]=true; //벌통 체크 
//			honey  =i;
//			Bee(1,0);
//			visited[i]=false;
//		}

		int result = 0;
		// 첫두꿀
		for (int i = 2; i < N; i++) {
			result =Math.max(result,(sum[N] - sum[1] - space[i] + sum[N] - sum[i]));
		}
		// 첫꿀두
		for (int i = 2; i < N; i++) {
			result = Math.max(result,(sum[i]-sum[1]+sum[N]-sum[i-1]-space[N]));
		}

		// 꿀첫두
		for (int i = 2; i < N; i++) {
			result = Math.max(result,(sum[i] - space[i] + sum[N - 1] - space[i]));

		}

		System.out.println(result);
	}
//	public static void Bee(int start, int cnt) {
//		//System.out.println("들어와?");
//		if(cnt==2) {
//			//벌의 위치가 완성... 그리고 거리 세어주기 
//			//System.out.println("들어와?2");
//			//System.out.println(count());
//			System.out.println(honey+" "+Tobe[0]+" "+Tobe[1]);
//			 answer = Math.max(answer,count());
//			 return;
//		}
//		for(int i =start;i<=N;i++) {
//			if(!visited[i]) {
//				Tobe[cnt] = i; //자리를 기억해야지 
//				visited[i]=true;
//				Bee(i+1,cnt+1);
//				visited[i] = false;
//			}
//		}
//	}
//	public static int count() {
//		int result=0;
//		//첫두꿀
//		if(Tobe[0]<honey && Tobe[1]<honey ) {
//			//System.out.println("첫두꿀"+Tobe[0]+" "+Tobe[1]+" "+honey);
//			result = sum[honey]-sum[Tobe[1]]+sum[honey]-sum[Tobe[0]]-space[Tobe[1]];
//			
//		}
//		//첫꿀두
//		else if(Tobe[0]<honey&& Tobe[1]>honey) {
//			//System.out.println("첫꿀두"+Tobe[0]+" "+honey+" "+Tobe[1]);
//			result = sum[honey]-sum[Tobe[0]]+sum[Tobe[1]]-sum[honey-1]-space[Tobe[1]];
//		}
//		//꿀첫두
//		else if(honey<Tobe[0] &&honey<Tobe[1]) {
//			//System.out.println("꿀첫두"+honey+" "+Tobe[0]+" "+Tobe[1]);
//			result = sum[Tobe[0]]-sum[honey-1]-space[Tobe[0]]+sum[Tobe[1]]-sum[honey-1]-space[Tobe[0]]-space[Tobe[1]];
//		}
//		return result;
//	}

}
