import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
public class DAA005 {
    public static void main(String[] args) {
        FastScanner stdin = new FastScanner(System.in);
        int t = stdin.nextInt();
        int list[] = new int[t];
        int s = 0;
        int sum[] = new int[t+1];
        
        while(s < t){
            int n = stdin.nextInt();
            list[s] = n;
            if(s == 0){
                sum[s] = n;
            }
            else{
                sum[s] = n+ sum[s-1];
            }

            s++;
        }
        s = 0;
        int p  = stdin.nextInt();
        int list2[] = new  int[p*2];
        while(s < p*2){
            int y  = stdin.nextInt();
            list2[s] = y ;
            s++;
        }
        s = 0;
        while(s < p*2){
            if(list2[s] == 1){
                FastPrint.out.println(sum[list2[s+1]-1]);
                
            }
            else{
                FastPrint.out.println(sum[list2[s+1]-1]-sum[list2[s]-2]);
                
            }
            s+=2;
        }
        FastPrint.out.close();

    }
}