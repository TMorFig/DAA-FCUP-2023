import java.util.*;
public class DAA021{
    public static void main(String[] args) {
        FastScanner stdin = new FastScanner(System.in);
        int a = stdin.nextInt();
        int r = stdin.nextInt();
        int[] print= new int[r];
        String[] buf = new String[2];
        int counter  =0;
        String s;
     
        TreeMap<Integer, Integer> arv = new TreeMap<>();
        for(int i = 0; i!= a+r; i++){
            s = stdin.nextLine();
            buf = s.split(" ");
            if(buf[0].equals("BAK")){
                if(arv.containsKey(Integer.parseInt(buf[1])) == false){
                    arv.put(Integer.parseInt(buf[1]),1);
                }
                else{
                    arv.replace(Integer.parseInt(buf[1]),arv.get(Integer.parseInt(buf[1]))+1);
                }
                
            }
            if(buf[0].equals("MIN")){
                print[counter] = arv.firstKey();
                counter+=1;
                if(arv.get(arv.firstKey()) == 1){
                    arv.remove(arv.firstKey());
                }
                else{
                    arv.replace(arv.firstKey(),arv.get(arv.firstKey())-1);
                }

            }
            if(buf[0].equals("MAX")){
                print[counter] = arv.lastKey();
                counter+=1;
                if(arv.get(arv.lastKey()) == 1){
                    arv.remove(arv.lastKey());
                }
                else{
                    arv.replace(arv.lastKey(),arv.get(arv.lastKey())-1);
                }
            }


        }
        for(int i = 0; i != r; i++){
            FastPrint.out.println(print[i]);
        }
        FastPrint.out.close();
        
    }
}