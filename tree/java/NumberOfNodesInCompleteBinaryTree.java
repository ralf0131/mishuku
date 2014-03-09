/* Problem statement:
 * Count the number of nodes given a complete binary tree.
 * Complete binary tree example:
 *      14
 *      /\
 *     7  4
 *    /\  /
 *   3  8 5
 * Complexity: T(n) = T(n/2) + log(n) => T(n) = log(n)
 */
 
 
public class NumberOfNodesInCompleteBinaryTree {

  public static void main(String []args) {
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
    System.out.println(numberOfNodes(n1));
  }
 
  public static int height(TreeNode root) {
    int height = 0;
    TreeNode cur = root;
    while (cur != null) {
      height++;
      cur = cur.left;
    }
    return height;
  }
 
  public static int numberOfNodes(TreeNode root) {
    if (root == null) return 0;
    int h = height(root);
    int left = 0;
    int right = 0;
    if (height(root.right) == h - 1) {
      // last node in right sub-tree
      left = (int)Math.pow(2, h - 1) - 1; // left sub-tree is a full binary tree
      right = numberOfNodes(root.right);
    } else {
      // last node in lefe node
      left = numberOfNodes(root.left);
      right = (int)Math.pow(2, h - 2) - 1; // right sub-tree is a full binary tree
    }
    return left + right + 1;
  }
}
 
class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int value;
  public TreeNode(int v) { this.value = v; }
}
