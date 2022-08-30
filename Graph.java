import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Graph {
  private int countNodes;
  private int countEdges;
  private int[][] adjMatrix;

  public Graph(int countNodes) {
    this.countNodes = countNodes;
    this.adjMatrix = new int[countNodes][countNodes];
  }

  public int getCountNodes() {
    return this.countNodes;
  }

  public int getCountEdges() {
    return this.countEdges;
  }

  public int[][] getAdjMatrix() {
    return this.adjMatrix;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < this.adjMatrix.length; i++) {
      for (int j = 0; j < this.adjMatrix[i].length; j++) {
        str += this.adjMatrix[i][j] + "\t";
      }
      str += "\n";
    }
    return str;
  }

  public void addEdge(int source, int sink, int weight) {
    if (source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
      System.err.println("Invalid value for source, sink or weight!");
      return;
    }
    this.adjMatrix[source][sink] = weight;
    this.countEdges++;
  }

  public void addEdgeUnoriented(int u, int v, int w) {
    if (u < 0 || u > this.countNodes - 1 || v < 0 || v > this.countNodes - 1 || w <= 0) {
      System.err.println("Invalid value for source, sink or weight!");
      return;
    }
    this.adjMatrix[u][v] = w;
    this.adjMatrix[v][u] = w;
    this.countEdges += 2;
  }

  public int degree(int node) {
    int degree = 0;
    for (int i = 0; i < adjMatrix[node].length; i++) {
      if (this.adjMatrix[node][i] != 0) {
        degree++;
      }
    }
    return degree;
  }

  public int highestDegree() {
    int count = 0;
    for (int i = 0; i < this.adjMatrix.length; i++) {
      int aux = degree(i);
      if (aux > count) {
        count = aux;
      }
    }
    return count;
  }

  public int lowestDegree() {
    int count = 0;
    for (int i = 0; i < this.adjMatrix.length; i++) {
      int aux = degree(i);
      if (aux <= count) {
        count = aux;
      }
    }
    return count;
  }

  public Graph complement() {
    Graph g2 = new Graph(this.adjMatrix.length);
    for (int i = 0; i < this.adjMatrix.length; i++) {
      for (int j = 0; j < this.adjMatrix[i].length; j++) {
        if (i != j && this.adjMatrix[i][j] == 0) {
          g2.addEdge(i, j, 1);
        }
      }
    }
    return g2;
  }

  public float density() {
    return (float) (this.countEdges * 2) / (this.countNodes * (this.countNodes - 1));
  }

  public boolean subGraph(Graph g2) {
    if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
      return false;
    for (int i = 0; i < g2.adjMatrix.length; i++) {
      for (int j = 0; j < g2.adjMatrix[i].length; j++) {
        if (this.adjMatrix[i][j] == 0 && g2.adjMatrix[i][j] != 0)
          return false;
      }
    }
    return true;
  }

  public ArrayList<Integer> bfs(int s) {

    int[] desc = new int[this.countNodes];
    ArrayList<Integer> Q = new ArrayList<>();
    Q.add(s);
    ArrayList<Integer> R = new ArrayList<>();
    R.add(s);
    desc[s] = 1;

    while (Q.size() > 0) {
      int u = Q.remove(0);
      for (int v = 0; v < this.adjMatrix[u].length; v++) {
        if (this.adjMatrix[u][v] != 0) {
          if (desc[v] == 0) {
            Q.add(v);
            R.add(v);
            desc[v] = 1;
          }
        }
      }
    }
    return R;
  }

  public boolean connected() {
    return this.bfs(0).size() == this.countNodes;
  }

  /*
   * public Graph(String fileName) throws IOException {
   * File file = new File(fileName);
   * FileReader reader = new FileReader(file);
   * BufferedReader bufferedReader = new BufferedReader(reader);
   * 
   * // Read header
   * String[] line = bufferedReader.readLine().split(" ");
   * this.countNodes = (Integer.parseInt(line[0]));
   * int fileLines = (Integer.parseInt(line[1]));
   * 
   * // Create and fill adjMatrix with read edges
   * this.adjMatrix = new int[this.countNodes][this.countNodes];
   * for (int i = 0; i < fileLines; ++i) {
   * String[] edgeInfo = bufferedReader.readLine().split(" ");
   * int source = Integer.parseInt(edgeInfo[0]);
   * int sink = Integer.parseInt(edgeInfo[1]);
   * int weight = Integer.parseInt(edgeInfo[2]);
   * addEdge(source, sink, weight);
   * }
   * bufferedReader.close();
   * reader.close();
   * }
   */

  public ArrayList<Integer> dfs(int s) {
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> S = new ArrayList<>();
    S.add(s);
    ArrayList<Integer> R = new ArrayList<>();
    R.add(s);
    desc[s] = 1;

    while (S.size() > 0) {
      int u = S.get(S.size() - 1);
      boolean unstack = true;
      for (int v = 0; v < this.adjMatrix[u].length; v++) {
        if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
          S.add(v);
          R.add(v);
          desc[v] = 1;
          unstack = false;
          break;
        }
      }
      if (unstack) {
        S.remove(S.size() - 1);
      }
    }

    return R;
  }

  public boolean nonOriented(){
    for(int i = 0; i < this.adjMatrix.length; i++){
      for(int j = 0; j < this.adjMatrix[i].length; j++){//j = i+1 reduz o tempo
        if(this.adjMatrix[i][j] != this.adjMatrix[j][i]){
          return false;
        }
      }
    }
    return true;
  }

  public ArrayList<Integer> dfs_rec(int s){
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> R = new ArrayList<>();
    dfs_recAux(s, desc, R);
    return R;
  }
  
  public void dfs_recAux(int u, int[] desc, ArrayList<Integer> R) {
    desc[u] = 1;
    R.add(u);
    for (int v = 0; v < this.adjMatrix[u].length; ++v) {
      if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
        dfs_recAux(v, desc, R);
      }
    }
  }
    
}