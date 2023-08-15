import java.util.*;
public class DAA014 {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();

        double[][] pares = new double[n][2];
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            Double a = scanner.nextDouble();
            Double b = scanner.nextDouble();
            pares[i][0] = a;
            pares[i][1] = b;
            ratio[i] = b/a;

        }
        int[] ind = indic(ratio);
        int i = 0;
        while(i != n-1){
            FastPrint.out.print(ind[i]+ " ");
            i++;
        }
        FastPrint.out.println(ind[i]);
        FastPrint.out.close();
        

        
    }
    public static int[] indic(double[] arr) {
        int n = arr.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingDouble(i -> -arr[i]));
        int[] sortedIndices = new int[n];
        for (int i = 0; i < n; i++) {
            sortedIndices[i] = indices[i] + 1;
        }
        return sortedIndices;
    }
    
    
}
