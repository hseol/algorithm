import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_11478_서로다른부분문자열의개수_실3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<String>();
		String str = br.readLine();
		// System.out.println(str.substring(4, 5));
		int len = str.length();

		for (int i = 1; i <= len; i++) {
			for (int j = 0; j+i <= str.length(); j++) {
				set.add(str.substring(j, j + i));
			}
		}
		System.out.println(set.size());
	}

}
