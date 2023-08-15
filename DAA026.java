import java.util.Scanner;



class colony {
    char data[][];
    int rows;     
    int cols; 

    colony(int r, int c) {
        data = new char[r][c];
        rows = r;
        cols = c;
        
        
    }

    public void read(Scanner in) {
        String a = "";
        char[] list = new char[cols];
        int i = 0;
        int j = 0;
        for ( i=0; i<rows; i++){
            a = in.next();
            for (j=0; j<cols; j++){
                list[j] = a.charAt(j);
                data[i][j] = list[j];
            
            }

        }
    }

    public String toString() {
        String ans = "";
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++)
                ans += data[i][j] + "";
            ans += "\n";
        }
        return ans;
    }
    public int countvirus(int i, int k){
        int counter = 0;
        counter +=1;
        if (i != 0 && k != 0){
            if (data[i-1][k-1]== '#'){
                data[i][k] ='.';
                counter = counter + countvirus(i-1, k-1);
               
            }
        }
        if (i != 0 ){
            if (data[i-1][k] == '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i-1, k);
                
            }
        }
        if (i != 0 && k != cols-1 ){
            if (data[i-1][k+1] == '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i-1, k+1);
                
            }
        }
        if ( k != cols-1 ){
            if (data[i][k+1] == '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i, k+1);
                
            }
        }
        if ( k != 0 ){
            if (data[i][k-1] == '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i, k-1);
                
            }
        }
        if (i != rows-1 && k != cols-1  ){
            if (data[i+1][k+1] == '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i+1, k+1);
                
            }
        }
        if (i != rows-1 && k != 0  ){
            if (data[i+1][k-1] == '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i+1, k-1);
                
            }
        }
        if (i != rows-1 ){
            if (data[i+1][k]== '#'){
                data[i][k] = '.';
                counter = counter + countvirus(i+1, k);
                
            }
        }
        data[i][k] = '.';
        return counter;

    }
    public int countcolony(){
        int i = 0;
        int k = 0;
        int max = 0;
        int counter = 0;
        while (i != rows){
            while(k != cols){
                if(data[i][k] == '#'){
                    counter = countvirus(i, k);
                }
                if (counter> max){
                    max = counter;
                }
                k+=1;
            }
            counter = 0;
            k = 0;
            i+=1;
        }
        return max;
    }

}
public class DAA026 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int k = stdin.nextInt();
        int[] resp =new int[k];
        for(int i = 0; i<k; i++){
            int linhas = stdin.nextInt();
            int colunas = stdin.nextInt();
            colony mat = new colony(linhas,colunas);
            mat.read(stdin);
            resp[i] = mat.countcolony();

        }
        for(int i = 0; i != k; i++){
            System.out.println(resp[i]);
        }
    
        
    }
    
}

