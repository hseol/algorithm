package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_1822_차집합_실4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> setA = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (setA.contains(num)) {
				setA.remove(num);
			}
		}
		sb.append(setA.size()).append("\n");
		if(setA.size()!=0) {
			for(int i :setA) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);

	}

}
