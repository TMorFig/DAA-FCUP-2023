
import java.util.*;
public class DAA009 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String k = input.nextLine();
        char[] list = stringToCharArray(k);
        
        
        
    }
    public static char[] stringToCharArray(String input) {
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i);
        }
        return result;
    }
    
}
