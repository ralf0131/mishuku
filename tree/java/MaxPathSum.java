/* Problem statement:
 * Find out the path in a tree with max sum of each node in the path.
 * Example:
 *     -10
 *   /  |  \
 *  2   3   4
 *     / \
 *    5  -1
 *       /
 *      6
 *     /
 *    -1
 * the path with max sum should be 13 (from 5 -> 3 -> -1 -> 6)
 * There are four possibility to be max sum of path.
 * 1. node itself
 * 2. node itself + max child val
 * 3. max child val
 * 4. max child val + second max child value + node itself
 */
import java.util.List; 
 
public class MaxPathSum {
  
  public static int maxTreePathSum(TreeNode root) {
    int[] max = new int[1];
    maxPathSum(root, max);
    return max[0];
  }
  public static int maxPathSum(TreeNode root, int[] max) {
    if (root == null) return 0;
    int maxChild1 = 0;
    int maxChild2 = 0;
    for (TreeNode node : root.children) {
      int temp = maxPathSum(node, max);
      if (temp > maxChild1) {
        maxChild2 = maxChild1;
        maxChild1 = temp;
      }
      else if (temp > maxChild2) maxChild2 = temp;
    }
    
    // retMax = max{ maxChild1 + root.val, root.val }
    int retMax = Math.max(maxChild1 + root.val, root.val);
    if (maxChild2 == Integer.MIN_VALUE) maxChild2 = 0;
    int maxCandidate = maxChild1 + maxChild2 + root.val;
    // max = max{ maxChild1 + root.val, root.val, maxChild1, maxCandidate }
    max[0] = Math.max(max[0], Math.max(Math.max(retMax, maxChild1), maxCandidate));
    return retMax;
  }
}
 
class TreeNode {
  public List<TreeNode> children;
  public int val;
  public TreeNode(int v, List<TreeNode> children) {
    this.children = children;
    this.val = v;
  }
}
