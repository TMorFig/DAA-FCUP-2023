import java.util.Scanner;
public class DAA003 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n  = stdin.nextInt();
        stdin.nextLine();
        for(int i=0;i<n;i++){
            String[] s = stdin.nextLine().split(" ");
            String m1=s[0];

            String m2=s[1];
            int num1 = cenas(m1);
            int num2 = cenas(m2);
            System.out.println(Math.abs(num1-num2));
        }
    }
    public static int generation(String m){
        int k = 5290000;
        if (Character.isAlphabetic(m.charAt(0))){
            if(Character.isAlphabetic(m.charAt(6)))
                return 3*k;
            else
                return 0;
        }
        else{

            if(Character.isAlphabetic(m.charAt(6)))
                return 1*k;

            else

                return 2*k;
        }
        
    }

    public static int cenas(String m){
        int n = 1;
        int out = generation(m);
        for(int i=7;i>=0;i--){
            if(Character.isDigit(m.charAt(i))){
                out+=(m.charAt(i)-'0')*n;
                n*=10;
            }
        }
        for(int i=7;i>=0;i--){
            if(Character.isAlphabetic(m.charAt(i))){
                int value = m.charAt(i) - 'A';
                if(m.charAt(i)>'K') {
                    value--;
                }
                    
                if(m.charAt(i)>'W'){value--;} 
                if(m.charAt(i)>'Y'){value--;} 
                out+=value*n;
                n*=23;
            }
        }
        return out;
    }
    public static int geracao(String matricula) {
        if (matricula.matches("[A-Z]{2}-[0-9]{2}-[0-9]{2}")) {
            return 1;
        } else if (matricula.matches("[0-9]{2}-[0-9]{2}-[A-Z]{2}")) {
            return 2;
        } else if (matricula.matches("[0-9]{2}-[A-Z]{2}-[0-9]{2}")) {
            return 3;
        } else if (matricula.matches("[A-Z]{2}-[0-9]{2}-[A-Z]{2}")) {
            return 4;
        } else {
            return -1;
        }
    }

    
    
}
