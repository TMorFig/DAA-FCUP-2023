import java.util.Scanner;
public class DAA013 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] pares = new int[n][2];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            pares[i][0] = a;
            pares[i][1] = b;
        }

        int i = 0;
        int resultado = 0;
        int comprimento = 0;
        int tail = 0;
        int head = 0;

        while(comprimento < m){
            while(i != n ){
                if(pares[i][0] == tail && pares[i][1] > head ){
                    head = pares[i][1];
                }
                else if (pares[i][0] < tail && pares[i][1] > head){
                    head = pares[i][1];
                }
                i++;
            }
            comprimento = comprimento + (head-tail);
            i = 0;
            tail = head;
        
            
            resultado++;
        }
   
        System.out.println(resultado);

        
    }

}