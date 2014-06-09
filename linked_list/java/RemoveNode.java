//package linkedlist;
//import linkedlist.LinkedListHelper;

public class RemoveNode {
    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 8, 7, 6};
        Node head = LinkedListHelper.createLinkedList(arr);
        LinkedListHelper.printLinkedList(head);
        Node removedHead = removeNode(head, 8);
        LinkedListHelper.printLinkedList(head);
        removedHead = removeNode(removedHead, 4);
        LinkedListHelper.printLinkedList(removedHead);
    }

    // remove all nodes whose value = v
    // return the head node after removal
    // test case 
    /*
        4, 8, 7, 6 => remove 8
        4, 8, 7, 6 => remove 4
        4, 4, 4    => remove 4
     */
    public static Node removeNode(Node head, int v) {
        // do some check
        if (head == null) return null;
        Node prev = null;
        Node cur = head;
        while(cur != null) {
            if (cur.value == v) {
                // we should remove cur
                if (prev == null) {
                    // we are removing the head node
                    head = head.next;
                    cur = head;
                } else {
                    // we are in the middle of the list
                    prev.next = cur.next;
                    cur.next = null;
                    cur = prev.next;
                }
            } else {
                // move cur and prev forward
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }


}

