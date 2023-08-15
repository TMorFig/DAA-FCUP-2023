import java.util.*;

class DAA018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int moedas[] = new int[n];
        for(int k = 0; k < n; k++){
            moedas[k] = scanner.nextInt();
        }
        int perguntas = scanner.nextInt();
        int soma[] = new int[perguntas];
        int max = -1;
        for(int i = 0; i < perguntas; i++){
            soma[i] = scanner.nextInt();
            if(soma[i] > max){
                max = soma[i];
            }
        }
        Arrays.sort(moedas);
        int[][] storedlist = new int[max+1][];
        storedlist[0] = new int[]{0};
        for(int y = 1; y <= max; y++){
            storedlist[y] = new int[]{-1};
        }
        for(int u = 0; u < moedas.length; u++){
            storedlist[moedas[u]] = new int[]{1, u};
        }
        for(int t = 1; t <= max; t++){
            storedlist = jgldiff(t, moedas, storedlist, max);
        }
        for(int y = 0; y < soma.length; y++){
            System.out.print(soma[y] + ": ");
            int[] answer = storedlist[soma[y]];
            System.out.print("[" + answer[0] + "] ");
            for(int i = 1; i < answer[0]; i++){
                System.out.print(moedas[answer[answer.length-i]] + " ");
            }
            System.out.println(moedas[answer[1]]);
        }
    }
    public static int[][] jgldiff(int valor, int[]moedas, int[][] storedlist, int max){
        int[][] store = storedlist.clone();
        int storado = Integer.MAX_VALUE;
        int path = -1;
        if(store[valor][0] > 0){
            return store;
        }
        else{
            for(int k = 0; k < moedas.length;  k++){
                if(valor-moedas[k] >= 0){
                    if (store[valor-moedas[k]][0] >= 0 && store[valor-moedas[k]][0] < storado ){
                        storado = store[valor-moedas[k]][0];
                        path = k;        
                    }
                }
            }
            if(path >= 0){
                store[valor] = new int[store[valor-moedas[path]].length + 1];
                store[valor][0] = store[valor-moedas[path]][0] + 1;
                for(int i = 1; i <= store[valor-moedas[path]][0]; i++){
                    store[valor][i] = store[valor-moedas[path]][i];
                }
                store[valor][store[valor][0]] = path;
            } else {
                store[valor] = new int[]{-1};
            }
        }
        return store;
    }
}