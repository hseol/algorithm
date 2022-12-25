package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19941_햄버거분배_실3 {
	static int N, K;
	static char[] map;
	static boolean[] people;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int count=0;
		map = new char[N];
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			map[i] = str.charAt(i);
//			if(map[i]=='P') {
//				people[i]=true;
//			}//사람 체크해줘
		}//입력 끝 
		
		for(int i=0;i<map.length;i++) {
			if(map[i]!='P')continue;
			else {//피라면
				for(int j=-K;j<=K;j++) {
					if(i+j<0)continue;
					if(i+j>=N)continue;
					if(map[i+j]=='H') {
						map[i+j]='A';
						count++;
						break;
						
					}
				}
			}
		}
		System.out.println(count);
		
	}

}
