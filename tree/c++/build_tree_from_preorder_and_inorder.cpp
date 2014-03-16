#include <iostream>
using namespace std;

/**
 * Problem statement:
 * Given the pre-order traversal sequence and the in-order traversal sequence,
 * build the tree from it.
 * Example: 
 * pre-order: 5, 8, 2, 6, 7, 3
 * in-order:  2, 8, 7, 6, 5, 3
 * The tree should be:
 *         5
 *        / \
 *       8   3
 *      / \
 *     2   6
 *        /
 *       7
 */

class TreeNode {
  public:
    TreeNode* left;
    TreeNode* right;
    int val;
    TreeNode(int v) { val = v; }
};

TreeNode* buildTreeHelper(int* pre, int preStart, int preEnd, int* in, int inStart, int inEnd) {
  // check invalid
  if (!pre || !in) return NULL;
  if (preStart < 0 || preEnd < 0 || preStart > preEnd) return NULL;
  if (inStart < 0 || inEnd < 0 || inStart > inEnd) return NULL;
  if ((preEnd - preStart) != (inEnd - inStart)) return NULL;
  // recursion end condition
  if (preStart == preEnd) return new TreeNode(pre[preStart]);
  // find preStart in in-order
  int i = inStart;
  while (i <= inEnd && in[i] != pre[preStart]) i++;
  if (i > inEnd) return NULL; // could not find, invalid
  TreeNode* n = new TreeNode(pre[preStart]);
  n->left = buildTreeHelper(pre, preStart+1, preStart+i-inStart, in, inStart, i-1);
  n->right = buildTreeHelper(pre, preStart+i-inStart+1, preEnd, in, i+1, inEnd);
  return n;  
}


TreeNode* buildTree(int* pre, int* in, int len) {
  return buildTreeHelper(pre, 0, len-1, in, 0, len-1);
}

void preOrder(TreeNode* root) {
  cout << root->val << ", ";
  if (root->left) preOrder(root->left);
  if (root->right) preOrder(root->right);
}

void inOrder(TreeNode* root) {
  if (root->left) inOrder(root->left);
  cout << root->val << ", ";
  if (root->right) inOrder(root->right);
}

int main() {
  int a[] = {12, 3, 5, 11, 9, 15}; //{5, 8, 2, 6, 7, 3};
  int b[] = {5, 3, 12, 9, 11, 15}; //{2, 8, 7, 6, 5, 3};
  TreeNode* root = buildTree(a, b, 6);
  preOrder(root);
  cout << endl;
  inOrder(root);
  cout << endl;
}
