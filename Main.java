class Main {
  public static void main(String[] args) {
    Graph g1 = new Graph(4);
    g1.addEdge(0, 1 , 3);
    g1.addEdge(1, 0 , 2);
    g1.addEdge(2, 3 , 4);
    g1.addEdge(3, 4 , 4);//aviso
    g1.addEdge(3, 2 , 3);
    g1.addEdge(1, 2 , 1);
    System.out.println(g1);
    System.out.println(g1.degree(1));
  }
}