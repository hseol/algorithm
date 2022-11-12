package week4;

class Programmers70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int zeroCount = 0;
            for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '0') zeroCount++;

            answer[1] += zeroCount;
            int targetLength = s.length() - zeroCount;

            s = Integer.toBinaryString(targetLength);

            answer[0]++;
        }
        return answer;
    }
}