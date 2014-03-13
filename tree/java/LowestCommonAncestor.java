/* Problem statement:
 * Find the lowest common ancestor of two nodes in a given binary tree.
 * For example, the lowest common ancestor of node 7 and 3 is 5.
 *       6 
 *      / \
 *     5   4
 *    /\   
 *   7  8
 *       \
 *        3
 * For a given node n, there are 4 possibility.
 * 1. LCA in left child
 * 2. LCA in right child
 * 3. n is the LCA
 * 4. n does not contain both of them in its sub-tree 
 * Complexity: T(n) = 2T(n/2) + O(1) => T(n) = O(n)
 */
public class LowestCommonAncestor {
  
  public static void main(String args[]) {
    TreeNode n1 = new TreeNode(6);
    TreeNode n2 = new TreeNode(5);
    TreeNode n3 = new TreeNode(4);
    TreeNode n4 = new TreeNode(7);
    TreeNode n5 = new TreeNode(8);
    TreeNode n6 = new TreeNode(3);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n5.right = n6;
    System.out.println(lowestCommonAncestor(n1, n4, n6).val);
    System.out.println(lowestCommonAncestor(n1, n3, n4).val);
    System.out.println(lowestCommonAncestor(n1, n2, n3).val);
    System.out.println(lowestCommonAncestor(n1, n6, n5).val);
    System.out.println(lowestCommonAncestor(n1, n1, n1).val);
    System.out.println(lowestCommonAncestor(n1, n6, null));
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
    int[] flag = new int[1];
    return LCA(root, n1, n2, flag);
  }

  // recursive version
  public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2, int[] flag) {
    if (root == null || n1 == null || n2 == null) return null;
    int rootFlag = 0;
    if (root == n1) rootFlag++;
    if (root == n2) rootFlag++;
    TreeNode temp = null;
    if (root.left != null) temp = LCA(root.left, n1, n2, flag); // search in the left sub tree
    if (temp != null) return temp; // LCA in left sub tree
    int leftFlag = flag[0]; // record the flag
    flag[0] = 0; // clear the flag
    if (root.right != null) temp = LCA(root.right, n1, n2, flag); // search in right sub tree
    if (temp != null) return temp; // LCA in right sub tree
    flag[0] = flag[0] + leftFlag + rootFlag;
    if (flag[0] == 2) return root; // root is LCA
    return null;
  }
}
 
class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int val;
  public TreeNode(int v) {
    this.val = v;
  }
}
