package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1049_기타줄_실4 {
static int N,M,money;
static int[] pack,line;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = 100000;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pack = new int[M];
		line = new int[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			line[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(pack);
		Arrays.sort(line);
		//패키지만 샀을때, 낱개로만 샀을때, 큼지막하게 패키지사고 낱개로 살때 세개 비교하기
		result = Math.min(((N/6)+1)*pack[0], N*line[0]);
		result = Math.min(result,(N/6)*pack[0]+(N%6)*line[0]);
//		if(N%6!=0) {
//			pack=(N/6+1)*pack;
//		}else {
//			pack = (N/6)*pack;
//		}
//		money = Math.min(pack, line*N);
//		result = Math.min(result, money);
		System.out.println(result);
		

	}

}

//난 무조건... 패키지 아니면 낱개라고 생각했음 킁... 접근 잘못함 큐ㅠ 
