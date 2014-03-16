#include <iostream>
using namespace std;

/*
  Problem statement:
  Given an binary tree, write a funcution to verify if it is a binary search tree.
  Example:
           8
          / \
         3   10
        / \    \
       1   6    14
          / \   /
         4   7 13
 */

class TreeNode {
  public:
    TreeNode* left;
    TreeNode* right;
    int val;
    TreeNode(int v) { val = v; }
};

bool verifyBSTHelper(TreeNode* root, int minValue, int maxValue) {
  if (root == NULL) return true;
  bool isLeftBST = verifyBSTHelper(root->left, minValue, root->val);
  bool isRightBST = verifyBSTHelper(root->right, root->val, maxValue);
  if (isLeftBST && isRightBST && minValue < root->val && maxValue > root->val) return true;
  return false;
}

bool verifyBST(TreeNode* root) {
  int min = INT_MIN;
  int max = INT_MAX;
  return verifyBSTHelper(root, min, max);
}

int main() {
  TreeNode* n1 = new TreeNode(8);
  TreeNode* n2 = new TreeNode(3);
  TreeNode* n3 = new TreeNode(10);
  TreeNode* n4 = new TreeNode(1);
  TreeNode* n5 = new TreeNode(6);
  TreeNode* n6 = new TreeNode(14);
  TreeNode* n7 = new TreeNode(4);
  TreeNode* n8 = new TreeNode(7);
  TreeNode* n9 = new TreeNode(13);  
  n1->left = n2;
  n1->right = n3;
  n2->left = n4;
  n2->right = n5;
  n3->right = n6;
  n5->left = n7;
  n5->right = n8;
  n6->left = n9;
  cout << verifyBST(n1) << endl;
}
