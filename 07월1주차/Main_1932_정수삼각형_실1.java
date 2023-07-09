import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형_실1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		int N =Integer.parseInt(br.readLine());
		Integer[][] arr = new Integer[N][N];
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		//입력끝
		for(int i=1;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				if(arr[i-1][j]==null) {
					arr[i][j]+=arr[i-1][j-1];
				}else if(j-1<0) {
					arr[i][j]+=arr[i-1][j];
				}else {
					arr[i][j]+=Math.max(arr[i-1][j],arr[i-1][j-1]);
				}		
			}
		}
		for(int i=0;i<N;i++) {
			result = Math.max(result, arr[N-1][i]);
		}
		System.out.println(result);
	}

}
