package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2109_순회강연_골3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[] checked;
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		int maxDay = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int date = Integer.parseInt(st.nextToken());
			maxDay = Math.max(date, maxDay);
			pq.add(new Lecture(pay, date));
		}
		int sum = 0;
		checked = new boolean[maxDay + 1];
		while (!pq.isEmpty()) {
			Lecture lecture = pq.poll();
			for (int i = lecture.date; i >= 1; i--) {
				if (!checked[i]) {
					checked[i] = true;
					sum += lecture.pay;
					break;
				}
			}

		}
		System.out.println(sum);
	}

}

class Lecture implements Comparable<Lecture> {
	int pay;
	int date;

	Lecture(int pay, int date) {
		this.pay = pay;
		this.date = date;
	}

	@Override
	public int compareTo(Lecture o) {
		if (o.pay > this.pay) {
			return 1;
		} else if (o.pay == this.pay) {
			if (o.date < this.date) {
				return 1;
			}
		}
		return -1;
	}
}
