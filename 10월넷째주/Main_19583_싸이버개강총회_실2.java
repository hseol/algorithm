package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_19583_싸이버개강총회_실2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		HashSet<String> result = new HashSet<>();
		int[][] dl = new int[3][2];
		int hour,min;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String start,end, dead,time,name, str="";
		start = st.nextToken();
		end = st.nextToken();
		dead = st.nextToken();
		//우리가 지켜야할 시간 조건 
		int tc = 17;
		while((str =br.readLine())!=null){
			st=new StringTokenizer(str," ");
			time = st.nextToken();
			name = st.nextToken();
			if(start.compareTo(time)>=0) {
				set.add(name);
			}
			if(end.compareTo(time)<=0 && dead.compareTo(time)>=0) {
				if(set.contains(name)) {
					result.add(name);
				}
			}
			
		}
		System.out.println(result.size());
	}

}
