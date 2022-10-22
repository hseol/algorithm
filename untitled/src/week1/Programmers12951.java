package week1;

public class Programmers12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean next = true;
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (next){
                if (Character.isLowerCase(c)) c = Character.toUpperCase(c);
                next = false;
            }
            if (c == ' ') next = true;
            sb.append(c);
        }
        return sb.toString();
    }
}
