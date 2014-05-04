
class Node<T> {
  public T value;
  public Node<T> next;

  public Node (T value) { this.value = value; }
}

public class ReverseLinkedList {

  public static void main(String[] args) {
    Node<Integer> n1 = new Node<Integer>(10);
    Node<Integer> n2 = new Node<Integer>(5);
    Node<Integer> n3 = new Node<Integer>(8);
    n1.next = n2;
    n2.next = n3;
    print(n1);
    print(reverseLinkedList(n1));
  }

  public static void print(Node head) {
    Node cur = head;
    while (cur != null) {
      System.out.print(cur.value + ", ");
      cur = cur.next;
    }
    System.out.println();
  }

  public static Node reverseLinkedList(Node head) {
    if (head == null) return null;
    Node pre = null;
    Node cur = head;
    Node pos = null;
    while (cur != null) {
      pos = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }
    return pre;
  }
}

