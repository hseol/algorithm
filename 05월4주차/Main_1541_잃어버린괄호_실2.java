/**
 * 
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**

  * @FileName : Main_1541_잃어버린괄호_실2.java

  * @Project : NewAlgo

  * @Date : 2023. 3. 5. 

  * @작성자 : hseol

  * @변경이력 :

  * @프로그램 설명 :

  */
public class Main_1541_잃어버린괄호_실2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<String> arr = new ArrayList<>();
		String[] tmp;
		int sum=0,result = 0;
		st = new StringTokenizer(br.readLine(),"-");
		while(st.hasMoreTokens()) {
			arr.add(st.nextToken());
		}
		
		String first = arr.get(0);
				tmp = first.split("\\+");
				for(String i : tmp) {
					result+=Integer.parseInt(i);
				}
			arr.remove(0); //첫번째거는 무조건 플러스일수밖에 없음
		
		
		
		for(String str : arr) {
				tmp = str.split("\\+");
				for(String i : tmp) {
					sum+=Integer.parseInt(i);
				}

			result-=sum;
		}
		System.out.println(result);
		
	}

}


/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정 
		String[] subtraction = br.readLine().split("-");
		
 
		for(int i = 0; i < subtraction.length; i++) {
			int temp = 0;
 
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
			String[] addition = subtraction[i].split("\\+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더한다. 
			for(int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
 
}*/
