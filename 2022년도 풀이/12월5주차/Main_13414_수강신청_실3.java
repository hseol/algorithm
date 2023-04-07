package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_13414_수강신청_실3 {
	static int K, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> checkNum = new LinkedHashSet<>();

		int count = 0;
		for (int i = 0; i < L; i++) {
			String stu = br.readLine();
			if (checkNum.contains(stu)) {
				checkNum.remove(stu);
			}
			checkNum.add(stu);

		} // 입력끝
		
		StringBuilder sb=new StringBuilder();
		Iterator it=checkNum.iterator();
		for(int i=0;i<K;i++) {
			if(!it.hasNext())
				break;
			sb.append(it.next()).append("\n");
		}
		System.out.println(sb);
	}

}
