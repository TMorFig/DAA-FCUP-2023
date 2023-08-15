import java.sql.RowId;
import java.util.Scanner;
//feito com parceria de Ricardo Ribeiro
// Estrutura para representar um no da arvore
class Node {
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node(int v) {
	isNull  = (v==0);
	isBlack = (v>=0);
	value   = Math.abs(v);
    }
}

public class DAA022 {

    // Ler input em preorder
    static Node readPreOrder(Scanner in) {
	int v = in.nextInt();
	Node aux = new Node(v);
	if (v!=0) {
	    aux.left  = readPreOrder(in);
	    aux.right = readPreOrder(in);
	}
	return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t) {
	if (t.isNull) return Integer.MAX_VALUE;
	int minLeft  = minimum(t.left);
	int minRight = minimum(t.right);
	return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
	if (t.isNull) return Integer.MIN_VALUE;
	int minLeft  = maximum(t.left);
	int minRight = maximum(t.right);
	return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
	if (t.isNull) return 0;
	return 1 + size(t.left) + size(t.right);
    }


    static Boolean test(Node t){
        if(t.isNull){
            return true;
        }
        if(!t.isBlack && (!t.left.isBlack || !t.right.isBlack)) {
            return false;
        }
        else{
            return test(t.left) && test(t.right);
        }
        
    }
    static boolean folha(Node t){
        if(t.isNull){

        return true;
        }
        if(t.left.isNull && t.right.isNull && (!t.left.isBlack || !t.right.isBlack)) {
            return false;
        }
        else{
            return folha(t.left) && folha(t.right);
        }
    }
    static boolean blackProperty(Node t){
        if(t.isNull) {
            return true;
        }
        int leftLength = blackPathLength(t.left);
        int rightLength = blackPathLength(t.right);
        return leftLength == rightLength && blackProperty(t.left) && blackProperty(t.right);
    }
    
    static int blackPathLength(Node t){
        if(t.isNull) return 0;
        return t.isBlack ? 1 + Math.max(blackPathLength(t.left), blackPathLength(t.right)) : Math.max(blackPathLength(t.left), blackPathLength(t.right));
    }

    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBST(Node node, int min, int max) {
        if (node.isNull) {
            return true;
        }
        if (node.value <= min || node.value >= max) {
            return false;
        }
        return isBST(node.left, min, node.value) && isBST(node.right, node.value, max);
    }



    // ---------------------------------------------------
    
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	
	int n =  in.nextInt();
	for (int i=0; i<n; i++) {
	    Node root = readPreOrder(in);
	    if(root.isBlack == true){
            if(test(root) == true){
                if(folha(root) == true){
                    if(blackProperty(root)){
                        if(isBST(root) == true){
                            System.out.println("SIM");
                        }
                        else{
                            System.out.println("NAO");
                        }
                    }
                    else{
                        System.out.println("NAO");
                    }
                }
                else{
                    System.out.println("NAO");
                }
            } 
            else{
                System.out.println("NAO");
            }
        }
        else{
            System.out.println("NAO");
        }
	}	
    }
}