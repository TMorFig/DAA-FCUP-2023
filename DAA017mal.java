import java.util.Scanner;

public class DAA017mal {
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int depth = stdin.nextInt();
        int[][] n = new int[depth][depth];
        for (int i = 0; i < depth; i++)
            for (int j = 0; j <= depth-depth+i && i!=depth ; j++)
                n[i][j] = 1;
    
   

       
        int destruidas = stdin.nextInt();
        int[][] list = new int[destruidas][2];
        for (int i = 0; i < destruidas; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            list[i][0] = a-1;
            list[i][1] = b-1;
        }
        for (int i = 0; i < destruidas; i++) {
            n[(list[i][0])][list[i][1]] = 0;
        }
        System.out.println(arrayToString(n));
        System.out.println(solve(n, 0, 0));
        
    }
    public static String arrayToString(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int col : row) {
                sb.append(col).append(",");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1); 
        return sb.toString();
    }
    public static int getright(int[][] s, int nivel, int pos){
        if( nivel != s.length-1 && pos != s.length-1 && s[nivel+1][pos+1] != 0 ){
            return 1;
        }
        else{
            return -1;
        }
    }
    public static int getleft(int[][] s, int nivel, int pos){
        if( nivel != s.length-1  && s[nivel+1][pos] != 0){
            return 1;
        }
        else{
            return -1;
        }
    }
    public static int solve(int[][] s, int nivel, int pos){
        int c = 0;
        if(getleft(s, nivel,pos) == 1 ){
            if (nivel != s.length-1 )
                c += solve(s, nivel+1, pos);
        }
        
        if(getright(s, nivel, pos)== 1){
            if(nivel != s.length-1 )
                c+= solve(s, nivel+1, pos+1);
            
        }
        if(nivel == s.length-1 && s[nivel][pos] != 0){
            c +=1;
        }
        return c;
        

    }
    

}