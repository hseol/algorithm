package 흑흑난몰라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Main_1339_단어수학_골4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][8];
		for (int i = 0; i < n; i++) {
			StringBuilder temp = new StringBuilder(br.readLine());
			while (temp.length() < 8) {
				temp.insert(0, "-");
			}
			arr[i] = temp.toString().toCharArray();
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int digit = 0; digit < 8; digit++) { // 10^0
			for (int i = 0; i < n; i++) {
				char now = arr[i][7 - digit];
				if (now != '-') {
					if (map.containsKey(now)) {
						map.put(now, map.get(now) + (int) Math.pow(10, digit));
					} else {
						map.put(now, (int) Math.pow(10, digit));
					}
				}
			}
		}

		LinkedList<Integer> list = new LinkedList<>();
		for (char alphabet : map.keySet()) {
			list.add(map.get(alphabet));
		}
		list.sort(Comparator.reverseOrder());

		int answer = 0;
		int num = 9;
		while (!list.isEmpty()) {
			answer += list.poll() * num--;
		}
		System.out.println(answer);
	}
}
