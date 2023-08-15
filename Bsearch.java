public class Bsearch {
    public static void main(String[] args) {
        int[] list = {10,9,8,7,6,5,4,3,2,1};
        System.out.println(bsdescending(0, list.length, list, 200));
    }

    static int bsdescending(int topo, int baixo, int[] list, int target){
        int meio = (baixo+topo)/2;
        if(target > list[meio]){
            baixo = meio;
        }
        if(target < list[meio]){
            topo = meio;
        }
        if(target == list[meio]){
            return meio;
        }
        if(topo == baixo){
            return -1;
        }
        return bsdescending(topo, baixo, list, target);
        
    }
}
