import java.util.*;
class DAA033{
    static int adj[][] ;   
    static int visited[];
    static int nos;
    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int aresta = stdin.nextInt();
        stdin.nextLine();
        adj = new int[n][n];
        String[] pares;
        
        String[] nos = new String[n];
       
        //0-- partida 1 destino
        String[] pares3 = new String[3];
        int ss = 0;
        String par = stdin.next();
        pares = par.split(" ");
        System.out.println(pares[0]);
        for(int i = 0; i<aresta; i++){
            pares3 = (stdin.nextLine()).split(" ");
            if(contains(pares3[0], nos) == false){
                nos[ss] = pares3[0];
                ss++;
            }
            if(contains(pares3[1], nos) == false){
                nos[ss] = pares3[1];
                ss++;
            }
            adj[index(pares3[0], nos)][index(pares3[1], nos)] = adj[index(pares3[1], nos)][index(pares3[0], nos)] = Integer.parseInt(pares3[2]);
            System.out.println(adj[index(pares3[0], nos)][index(pares3[1], nos)]);
            
        }

    }
    public static boolean contains(String x, String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(x)) {
                return true;
            }
        }
        return false;
    }
    public static int index(String x, String[] list){
        for(int i = 0; i != list.length; i++){
            if(list[i] == x){
                return i;
            }

        }
        return -1;
    }
}