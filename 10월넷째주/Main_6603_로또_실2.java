package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또_실2 {
static int number[];
static int[] lotto = new int[6];
	public static void main(String[] args) throws IOException {
		//K개의 수가 주어진다. 
		// 그 수로 만들 수 있는 6개의 조합 
		//사전적 순서로 출력돼야하기때문에 들어온 수를 먼저 정렬하고 그 다음에 조합으로 출력 
		//PQ 쓰나? 여튼 엔퀸처럼 백트래킹이용하는 문제 
		//0들어오면 종료 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int K = Integer.parseInt(st.nextToken());//K개의 수 
			
			if(K==0)break;
			number = new int[K];
			for(int i =0;i<K;i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(number); //오름차순으로 정리할 것
			Combi(0,0);
			System.out.println();
			
		
		}
		
		

	}
	public static void Combi(int cnt, int start) {
		if(cnt==6) {
			for(int i : lotto) {
				System.out.print(i+" ");
			}System.out.println();
			return;
		}
		for(int i =start;i<number.length;i++) {
			lotto[cnt] = number[i];
			Combi(cnt+1,i+1);
		}
	}

	
	
}
