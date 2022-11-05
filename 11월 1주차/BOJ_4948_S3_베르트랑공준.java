import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4948_S3_베르트랑공준 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int input;
		while(true) 
		{
			input = Integer.parseInt(br.readLine());
			
			if(input==0) 
				break;
			sb.append(sosoo(input)).append("\n");
		}
	
		System.out.println(sb);
	}

	public static int sosoo(int n) {
		int cnt=0;
		int num = 2*n+1;
		boolean prime[] = new boolean[num+1];
		
		if(n<=3)
			return 1;
		
		
		Arrays.fill(prime, false);
		prime[0]=prime[1]=true;
		
		for (int i = 2; i*i < num; i++) {
			
			if(!prime[i]) 
			{
				for (int j = i*i; j < num; j+=i) {
					prime[j]=true;
				}
			}
			
		}
		
		for(int i=n+1;i<num;i++) 
		{
			if(!prime[i]) {
				cnt++;
				//System.out.print(i+" ");
			}
		}
		
		
		
		return cnt;

	}

}