package SeleniumPractise;

import java.util.HashSet;
import java.util.Set;

public class duplicate {
    public static void main(String[] args) {
        String str = "saahil";

        Set<Character> s = new HashSet<>();

        for (int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(s.add(c) == false){
                System.out.println(c);
                break;
            }
        }
    }
}
