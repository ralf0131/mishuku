import java.util.Stack;

class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int val;
  public TreeNode(int v) { this.val = v; }
}

public class Traversal {

  public void preOrderRecursive(TreeNode root) {
    System.out.print(root.val + " -> ");
    preOrderRecursive(root.left);
    preOrderRecursive(root.right);
  }

  public void preOrderNonRecursive(TreeNode root) {
    Stack<TreeNode> s = new Stack<TreeNode>();
    s.push(root);
    while (!s.empty()) {
      TreeNode n = s.pop();
      System.out.print(n.val + " -> ");
      if (n.right != null) s.push(n.right);
      if (n.left != null) s.push(n.left);
    }
  }

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(14);
    TreeNode n2 = new TreeNode(7);
    TreeNode n3 = new TreeNode(4);
    TreeNode n4 = new TreeNode(3);
    TreeNode n5 = new TreeNode(8);
    TreeNode n6 = new TreeNode(5);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;

    Traversal t = new Traversal();
    t.preOrderNonRecursive(n1);
    System.out.println();
  }
}


