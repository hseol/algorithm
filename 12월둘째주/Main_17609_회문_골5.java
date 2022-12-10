package 흑흑난몰라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609_회문_골5 {

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        int t = Integer.parseInt(br.readLine());
	        while (t-- > 0) {
	            String now = br.readLine();
	            if (isPalin(now)) {
	                sb.append(0);
	            } else {
	                int left = 0, right = now.length() - 1;
	                boolean flag = false;
	                while (left < right) {
	                    if (now.charAt(left) != now.charAt(right)) {
	                        if (isPalin(now.substring(left + 1, right + 1)) || isPalin(now.substring(left, right))) {
	                            flag = true;
	                        }
	                        break;
	                    }
	                    left++;
	                    right--;
	                }
	                if (flag) sb.append(1);
	                else sb.append(2);
	            }

	            sb.append('\n');
	        }
	        System.out.println(sb);
	    }

	    static boolean isPalin(String s) {
	        int left = 0, right = s.length() - 1;
	        while (left < right) {
	            if (s.charAt(left++) != s.charAt(right--)) return false;
	        }
	        return true;
	    }
	}
	
}
