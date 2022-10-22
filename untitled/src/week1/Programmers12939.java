package week1;

import java.util.Arrays;

public class Programmers12939 {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        int[] nums = new int[numbers.length];

        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(nums);

        answer = nums[0] + " " + nums[nums.length - 1];
        return answer;
    }
}
