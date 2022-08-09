class Graph{
  private int countNodes;
  private int countEdges;
  private int[][] adjMatrix;

  public Graph(int countNodes){
    this.countNodes = countNodes;
    this.adjMatrix = new int [countNodes][countNodes]; 
  }

  public int getCountNodes(){
    return this.countNodes;
  }

  public int getCountEdges(){
    return this.countEdges;
  }

  public int[][] getAdjMatrix(){
    return this.adjMatrix;
  }

  public String toString(){
    String str = "";
    for(int i = 0; i < this.adjMatrix.length; i++){
      for(int j = 0; j < this.adjMatrix[i].length; j++){
        str += this.adjMatrix[i][j] + "\t";
      }
      str += "\n";
    }
    return str;
  }
  
  public void addEdge(int source, int sink, int weight){
    if(source < 0 || source > this.countNodes -1|| sink <0 || sink > this.countNodes -1|| weight <= 0){
        System.err.println("Invalid value for source, sink or weight!");
      return;
    }
    this.adjMatrix[source][sink] = weight;  
    this.countEdges++;
  }

  public int degree(int node){
    int degree = 0;
    for(int i = 0; i < adjMatrix[node].length; i++){
      if(this.adjMatrix[node][i] != 0){
        degree++;
      }
    }
   /*for(int i = 0; i < countNodes; i++){
      if(this.adjMatrix[i][node] != 0){
        degree++;
      }
    }*/
    return degree;
  }

}