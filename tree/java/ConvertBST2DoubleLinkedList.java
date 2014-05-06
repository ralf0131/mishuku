/*
 * Problem statement:
 * convert an binary search tree to a double linked list.
 *        6
 *      /  \
 *     3    10
 *    / \     \
 *   2   5     12
 * Example the output of the above BST should be:
 *   2 <-> 3 <-> 5 <-> 6 <-> 10 <-> 12 
 */

public class ConvertBST2DoubleLinkedList {

  public static void main(String[] args) {
    Node n1 = new Node(6);
    Node n2 = new Node(3);
    Node n3 = new Node(10);
    Node n4 = new Node(2);
    Node n5 = new Node(5);
    Node n6 = new Node(12);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.right = n6;
    Node listHead = convertBST2DoubleLinkedList(n1);
    Node cur = listHead;
    while (cur.right != null) {
      System.out.print(cur.value + " -> ");
      cur = cur.right;
    }
    System.out.println(cur.value);
    while (cur.left != null) {
      System.out.print(cur.value + " -> ");
      cur = cur.left;
    }
    System.out.println(cur.value); 
  }
   
  public static Node convertBST2DoubleLinkedList(Node head) {
    Node[] minAndMax = {null, null};
    convertBST2DoubleLinkedListRecursive(head, minAndMax);
    return minAndMax[0];
  }

  // an O(n) solution, using a array to record min and max value of each sub-tree
  public static void convertBST2DoubleLinkedListRecursive(Node head, Node[] minAndMax) {
    if (head == null) return;
    Node[] leftMinAndMax = {null, null};
    Node[] rightMinAndMax = {null, null};
    if (head.left != null) {
      convertBST2DoubleLinkedListRecursive(head.left, leftMinAndMax);
      Node leftMax = leftMinAndMax[1];
      if (leftMax != null) {
        leftMax.right = head;
        head.left = leftMax;
      }
    }
    if (head.right != null) {
      convertBST2DoubleLinkedListRecursive(head.right, rightMinAndMax);
      Node rightMin = rightMinAndMax[0];
      if (rightMin != null) {
        rightMin.left = head;
        head.right = rightMin;
      }
    }
    Node leftMin = leftMinAndMax[0];
    Node rightMax = rightMinAndMax[1];
    minAndMax[0] = leftMin == null ? head : leftMin;
    minAndMax[1] = rightMax == null ? head : rightMax;
  }
}

class Node {
  public Node left;
  public Node right;
  public int value;
  public Node(int value) { this.value = value; }
}
