
package String;
import java.util.PriorityQueue;

/**
 * 
 * @FileName : Solution_호텔대실.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 26.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Solution_155651_호텔대실_level2 {
//static String[][] book_time = {{"15:00", "17:00"},{"16:40", "18:20"},{"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}};
	static String[][] book_time = { { "09:10", "10:10" }, { "10:20", "12:20" } };

	// {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}
	public static void main(String[] args) {
		PriorityQueue<Integer> start, end;
		start = new PriorityQueue<>();
		end = new PriorityQueue<>();
		for (int i = 0; i < book_time.length; i++) {
			int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
			int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));

			endTime += 10;
			if (endTime % 100 >= 60) {
				endTime += 40;
			}
			start.offer(startTime);
			end.offer(endTime);
		}
		int answer = -1;
		int result = 0;
		while (!start.isEmpty()) {
			int titi = start.peek();
			int compa = end.peek();
			if (titi < compa) {
				result++;
				start.poll();
			} else if (titi == compa) {
				start.poll();
				end.poll();
			} else { // titi>compa
				result--;
				end.poll();
			}
			answer = Math.max(answer, result);

		}
		System.out.println(answer);

	}
}
