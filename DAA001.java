import java.util.Scanner;
public class DAA001 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        int list[] = new int[t];
        int counter = 0;
        int s = t;
        while(s > 0){
            int n = stdin.nextInt();
            list[s-1] = n;
            s--;
        }
        while(t > 0){
            if(list[t-1] == 42){
                counter+=1;
            }
            t--;
        }
        System.out.println(counter);

    }
}