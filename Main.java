class Main {
  public static void main(String[] args) {
    Graph g1 = new Graph(4);
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
    System.out.println("\n" + g1.complement().toString());
  }
}