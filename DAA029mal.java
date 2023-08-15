import java.util.*;
import java.util.Scanner;

public class DAA029mal {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        Character[][] palavras = new Character[n][11];
        String a;
        String usadas = "";
        String ordem = "";
        for(int i = 0; i!=n; i++){
            a = stdin.next();
            usadas = newchar(a, usadas);
            for(int p = a.length(); p <= 10; p++){
                a += " ";
            }
            for(int s = 0; s <=10 ; s++ ){
                palavras[i][s] = a.charAt(s);
            }
            
        }
        
        for(int i = 0; i<= 10; i++){
            for(int s = 0; s < n; s++){
                if(contem(palavras[s][i], usadas) == true){
                    ordem  = ordem + palavras[s][i];
                    
                    usadas = contemremove(palavras[s][i], usadas);
  
                }
            }
        }
        System.out.println(ordem);
  
    }
    static String newchar(String a, String list){
        for(int i = 0; i != a.length(); i++){
            if(!contem(a.charAt(i), list)){
                list += a.charAt(i);
            }
        }
        return list;
    }

    static boolean contem(Character comparado, String comparador){
        if(comparado == ' '){
            return false;
        }
        else{ 
            for(int i = 0; i!= comparador.length();i++){
                if(comparador.charAt(i) == comparado){
                    return true;
                }
                
            }
        }
        return false;
    }



    static String contemremove(Character comparado, String comparador) {
        for (int i = 0; i < comparador.length(); i++) {
            if (comparador.charAt(i) == comparado) {
                return comparador.substring(0, i) + comparador.substring(i + 1);
            }
        }
        return comparador;
    }
    public static void print2DMatrix(Character[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
