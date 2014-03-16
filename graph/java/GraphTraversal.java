import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Given an undirected graph, 
 * using breadth first search and depth first search to traverse it.
 * Example graph:
 *                 10
 *               /  |  \
 *              5   8   3
 *             / \ /
 *            1   6
 */

public class GraphTraversal {

  public static void main(String []args) {
    //List<Node> nodes = new ArrayList<Node>();
    Node n1 = new Node(10);
    Node n2 = new Node(5);
    Node n3 = new Node(8);
    Node n4 = new Node(3);
    Node n5 = new Node(1);
    Node n6 = new Node(6);
    n1.neighbors = new ArrayList<Node>();
    n1.neighbors.add(n2);
    n1.neighbors.add(n3);
    n1.neighbors.add(n4);
    n2.neighbors = new ArrayList<Node>();
    n2.neighbors.add(n1);
    n2.neighbors.add(n5);
    n2.neighbors.add(n6);
    n3.neighbors = new ArrayList<Node>();
    n3.neighbors.add(n1);
    n3.neighbors.add(n6);
    n4.neighbors = new ArrayList<Node>();
    n4.neighbors.add(n1);
    n5.neighbors = new ArrayList<Node>();
    n5.neighbors.add(n2);
    n6.neighbors = new ArrayList<Node>();
    n6.neighbors.add(n2);
    n6.neighbors.add(n3);
    BFS(n1);
  }

  // DFS using stack
  public static void DFS(Node first) {
    if (first == null) return;
    Stack<Node> s = new Stack<Node>();
    first.visited = true;
    s.push(first);
    while (!s.empty()) {
      Node n = s.pop();
      System.out.print(n.val + ", ");
      List<Node> neighbors = n.neighbors;
      if (neighbors == null) continue;
      for (int i = neighbors.size() - 1; i >= 0; i--) {
        Node temp = neighbors.get(i);
        if (!temp.visited) {
          temp.visited = true;
          s.push(temp);
        }
      }
    }
    System.out.println();
  }

  // BFS using queue
  public static void BFS(Node first) {
    if (first == null) return;
    Queue<Node> q = new LinkedList<Node>();
    first.visited = true;
    q.add(first);
    while (!q.isEmpty()) {
      Node n = q.poll();
      System.out.print(n.val + ", ");
      List<Node> neighbors = n.neighbors;
      if (neighbors != null) {
        for (int i = 0; i < neighbors.size(); i++) {
          Node temp = neighbors.get(i);
          if (!temp.visited) {
             temp.visited = true;
             q.add(temp);
          } 
        }
      }
    }
    System.out.println();
  }
}

class Node {
  public int val;
  public boolean visited = false;
  public List<Node> neighbors;
  public Node(int v) { this.val = v; } 
}
