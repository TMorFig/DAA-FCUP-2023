import java.util.*;



public class DAA010mal{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arrayN = new int[n];
        for (int i = 0; i < n; i++) {
            arrayN[i] = input.nextInt();
        }

        int[][] somas = new int[arrayN.length][arrayN.length];
        for(int k = 0; k < arrayN.length; k++){
            for(int s = 0; s <arrayN.length; s++){
                if (arrayN[s] != arrayN[k]){ 
                    somas[k][s] = arrayN[k] +arrayN[s];
                }
                else{
                    somas[k][s] = Integer.MIN_VALUE;
                }
            }
        }
        int pergunta = input.nextInt();
        int[] perguntas = new int[pergunta];
        for(int o = 0; o !=pergunta; o++ ){
            perguntas[o] =input.nextInt(); 

        }
        for(int o = 0; o !=pergunta; o++ ){
            if( containsup(somas, perguntas[o]) < -containsdown(somas, perguntas[o])){
                System.out.println(perguntas[o]+containsup(somas, perguntas[o]));
            }
            if( containsup(somas, perguntas[o]) > -containsdown(somas, perguntas[o])){
                System.out.println(perguntas[o]+containsdown(somas, perguntas[o]));
            }
            if( containsup(somas, perguntas[o]) == -containsdown(somas, perguntas[o]) && containsup(somas, perguntas[o]) != 0){
                System.out.print(perguntas[o]+containsdown(somas, perguntas[o])+ " ");
                System.out.println(perguntas[o]+containsup(somas, perguntas[o]));
            }
            if(containsup(somas, perguntas[o]) == -containsdown(somas, perguntas[o]) && containsup(somas, perguntas[o]) == 0){
                System.out.println(perguntas[o]+containsup(somas, perguntas[o]));
            }
            

        }
        


        
       


 

    }
    public static int contains(int[][] r, int k){
        int[] m = new int[r.length*r.length];
        int n = 0;
        for(int p = 0; p < r.length; p++){
            for(int s = 0; s < r.length; s++){
                m[n] = r[p][s];
                n++;
            }
        }
        Arrays.sort(m);
        int low = 0;
        int high = m.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (m[mid] == k) {
                return 1;
            } else if (m[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
        
            
        
    }
    public static int containsdown(int[][] r, int k){
        int a = 0;
        if(contains(r,k)== 1){
            return a;
        }
        if ( k == 0){
            return -9999999;
        }
        else{
                a = containsdown(r, k-1)-1;
        
        }
        return a;

    }
    public static int containsup(int[][] r, int k){
        int a = 0;
        if(contains(r,k)== 1){
            return a;
        }
        else{
                a = containsup(r, k+1)+1;
        }
        return a;
        
    }

}
