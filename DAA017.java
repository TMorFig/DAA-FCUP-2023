import java.util.Scanner;

public class DAA017 {
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int depth = stdin.nextInt();
        BOOL[][] lista = new BOOL[depth][depth];
   

        for (int i = 0; i < depth; i++)
            for (int j = 0; j < depth; j++)
                lista[i][j] = BOOL.OUT;

        for (int i = 0; i < depth; i++)
            for (int j = 0; j <= i; j++){
                lista[i][j] = BOOL.TRUE;
                cache[i][j] = -1 ;
            }
        int destruidas = stdin.nextInt();
        for (int i = 0; i < destruidas; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            lista[depth-a][b-1] = BOOL.FALSE; 
        }
        System.out.println(solve(depth,lista,0,0));
    }
    static long[][] cache = new long[1000][1000];

    enum BOOL {FALSE,TRUE,OUT}

    static long solve(int depth, BOOL[][] v, int i, int j){
        if (v[i][j] == BOOL.FALSE ) return 0;
        if (i == depth - 1) return 1;
        if (cache[i][j] == -1)  cache[i][j] = solve(depth,v,i+1,j) + solve(depth,v,i+1,j+1);
        return cache[i][j];
    }
    

}