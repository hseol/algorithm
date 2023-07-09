import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1744_수묶기_골4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				plus.add(num);
			} else {
				minus.add(num);
			}
		} // 입력 끝

		Collections.sort(minus);
		Collections.sort(plus, Collections.reverseOrder());
		
//		System.out.println("플러스");
//		for(int i:plus) {
//			System.out.print(i+" ");
//		}System.out.println();
		
//		System.out.println("마이너스");
//		for(int i :minus) {
//			System.out.print(i+" ");
//		}System.out.println();
		int sum = 0;
		for (int i = 0; i < plus.size(); i++) {
			if (i + 1 < plus.size() && plus.get(i) != 1 && plus.get(i + 1) != 1) {
				sum += plus.get(i) * plus.get(i + 1);
				i++;
			} else {
				sum += plus.get(i);
			}
		}

		int sum2 = 0;
		for (int i = 0; i < minus.size(); i++) {
			if (i + 1 < minus.size()) {
				sum2 += minus.get(i) * minus.get(i + 1);
				i++;
			} else {
				sum2 += minus.get(i);
			}
		}
		//System.out.println(sum+" "+sum2);

		System.out.println(sum + sum2);

	}

}
