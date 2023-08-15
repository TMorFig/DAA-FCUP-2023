import java.util.Scanner;

public class DAA002 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int t = stdin.nextInt();
        int listn[] = new int[t];
        int listk[] = new int[t];
        int s = t;
        while (t > 0) {
          
            int n = stdin.nextInt();
            int k = stdin.nextInt();
            listn[t-1] = n;
            listk[t-1] = k;
            t--;
        }
        while(s > 0){
            int i = listn[s-1] + 1;
            while (somadigitos(i) != listk[s-1]) {
                i++;
            }
            System.out.println(i);
            s--;

        }
       
    }

    public static int somadigitos(int n) {
        int soma = 0;
        while (n > 0){
            soma += n % 10;
            n /= 10;
        }
        return soma;
    }
}