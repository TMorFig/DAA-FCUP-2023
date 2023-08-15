// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
    public int distance;            // Distancia ao no origem da pesquisa

    Node() {
        adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph {
    int n;           // Numero de nos do grafo
    Node nodes[];    // Array para conter os nos
    static int diametro = 0;
    static SortedSet<Integer> excentricidades;
    static SortedSet<Integer> nos_centrais;
    static SortedSet<Integer> nos_perifericos;


    Graph(int n) {
        this.n = n;
        nodes  = new Node[n+1]; // +1 se nos comecam em 1 ao inves de 0
        //matriz = new int[n+1][n+1];
        for (int i=1; i<=n; i++)
            nodes[i] = new Node();
        excentricidades = new TreeSet<>();
        nos_centrais = new TreeSet<>();
        nos_perifericos = new TreeSet<>();
    }

    public void addLink(int a, int b) {
        nodes[a].adj.add(b);
        nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura
    public void bfs(int v) {
        int excentricidade_nos = Integer.MIN_VALUE;
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) nodes[i].visited = false;

        q.add(v);
        nodes[v].visited = true;
        nodes[v].distance = 0;

        while (q.size() > 0) {
            int u = q.removeFirst();
       

            
            if (nodes[u].distance > diametro) diametro = nodes[u].distance;
            if (nodes[u].distance > excentricidade_nos) excentricidade_nos = nodes[u].distance;
            for (int w : nodes[u].adj)
                if (!nodes[w].visited) {

                    q.add(w);
                    nodes[w].visited  = true;
                    nodes[w].distance = nodes[u].distance + 1; 
                }	    
        }
        excentricidades.add(excentricidade_nos);
    }

    public void bfs(int v, int raio, int d) {
        int excentricidade_nos = Integer.MIN_VALUE;
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) nodes[i].visited = false;

        q.add(v);
        nodes[v].visited = true;
        nodes[v].distance = 0;

        while (q.size() > 0) {
            int u = q.removeFirst();
            if (nodes[u].distance > diametro) diametro = nodes[u].distance;
            if (nodes[u].distance > excentricidade_nos) excentricidade_nos = nodes[u].distance;
            for (int w : nodes[u].adj)
                if (!nodes[w].visited) {
                    q.add(w);
                    nodes[w].visited  = true;
                    nodes[w].distance = nodes[u].distance + 1; 
                }	    
        }
        if(excentricidade_nos == raio) nos_centrais.add(v);
        else if(excentricidade_nos == d) nos_perifericos.add(v);
    }
}

public class DAA030 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Graph g = new Graph(n);
        int   e = in.nextInt();
        for (int i=0; i<e; i++) 
            g.addLink(in.nextInt(), in.nextInt());



        for(int i = 1; i <= n; i++) {
            g.bfs(i);

        }
        System.out.println(g.diametro);	
        Iterator<Integer> iterator = g.excentricidades.iterator();
        int raio = iterator.next();
     
        System.out.println(raio);
        for(int i = 1; i <= n; i++) {
            g.bfs(i, raio, g.diametro);
        }
      
        Iterator<Integer> iterator2 = g.nos_centrais.iterator();
        Iterator<Integer> iterator3 = g.nos_perifericos.iterator();
        System.out.print(iterator2.next());
       
        while(iterator2.hasNext()) {
            System.out.print(" ");
            System.out.print(iterator2.next());
        }

        System.out.println();
  


        System.out.print(iterator3.next());
        while(iterator3.hasNext()) {
            System.out.print(" ");
            System.out.print(iterator3.next());
        }
        System.out.println();
    }
}
