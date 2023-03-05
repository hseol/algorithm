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

