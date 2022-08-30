import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException {

  Graph g1 = new Graph(9);
    g1.addEdgeUnoriented(7, 5, 1);
    g1.addEdgeUnoriented(7, 1, 1);
    g1.addEdgeUnoriented(7, 2, 1);
    g1.addEdgeUnoriented(1, 0, 1);
    g1.addEdgeUnoriented(1, 4, 1);
    g1.addEdgeUnoriented(2, 3, 1);
    g1.addEdgeUnoriented(5, 6, 1);
    g1.addEdgeUnoriented(6, 8, 1);
    System.out.println(g1.bfs(7));
    System.out.println(g1.connected());
    System.out.println(g1.dfs_rec(5));

    Graph g2 = new Graph(4);
    g2.addEdge(0, 1, 1);
    g2.addEdge(0, 3, 1);
    g2.addEdge(1, 0, 1);
    g2.addEdge(2, 1, 1);
    g2.addEdge(3, 1, 1);
    System.out.println(g2.nonOriented());

    //Graph g2 = new Graph("graph1.txt");
    //System.out.println(g2);
    
   /*  Gbusca_Largura(s)raph g1 = new Graph(4);
    g1.addEdge(0, 1 , 3);
    g1.addEdge(1, 0 , 3);
    g1.addEdge(0, 3 , 4);
    g1.addEdge(3, 4 , 2);//aviso
    g1.addEdge(3, 0 , 4);
    //g1.addEdge(1, 2 , 1);
    System.out.println(g1);
    System.out.println(g1.degree(1));
    System.out.println("Maior grau: " + g1.highestDegree());
    System.out.println("Menor grau: " + g1.lowestDegree());
    System.out.println("\n" + "Complemento: " +"\n"+ g1.complement().toString());
    System.out.println("Densidade: " + g1.density());
    Graph g2 = new Graph(3);
    g2.addEdge(0, 1, 1);
    g2.addEdge(1, 0, 1);
    System.out.println("g2 é subGrafo? " + g1.subGraph(g2)); 
    Graph g3 = new Graph(4);
    g3.addEdge(1, 0, 1);
    g3.addEdge(3, 1, 1);
    System.out.println("g3 é subGrafo? " + g1.subGraph(g3)); */
  }
}