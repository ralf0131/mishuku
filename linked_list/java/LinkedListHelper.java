//package linkedlist;

public class LinkedListHelper {

    public static Node createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i=1; i<arr.length; i++){
            Node n = new Node(arr[i]);
            prev.next = n;
            prev = n;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}