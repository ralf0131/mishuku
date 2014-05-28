#include <iostream>
using namespace std;

class Node{
  public:
    Node* next;
    int value;
    Node(int v) { this->value = v; }
};

/**
 Remove all the node whose value=v in the given list, 
 return the new head of the list.
 e.g. 
 input list:  3 -> 4 -> 8 -> 6 -> 4, and number 4,
 output list: 3 -> 8 -> 6, and return 2
 test case:
   linked list(value to delete)
   NULL(4)
   4(4)
   4(3)
   1 -> 3 -> 2(1)
   4 -> 4 -> 4(4)
   1 -> 3 -> 2(2)
 */
Node* removeNode(Node* head, int v){
  if (head == NULL) return 0;
  Node* pre = NULL;
  Node* cur = head;
  int count = 0;
  while (cur != NULL) {
    if (cur->value == v) {
      // remove this node
      if(pre != NULL) pre->next = cur->next; // remove non-head not
      else head = cur->next; // remove head node
      delete cur;
      count++;
      cur = pre == NULL ? head : pre->next;
    } else {
      // moving forword
      pre = cur;
      cur = cur->next;
    } 
  }
  cout << "Number of nodes deleted: " << count << endl;
  return head;
}

Node* createLinkedList(int* arr, int length){
  if (arr == NULL) return NULL;
  Node* pre = new Node(arr[0]);
  Node* head = pre;
  for (int i=1; i<length; i++){
    Node* n = new Node(arr[i]);
    pre->next = n;
    pre = n;
  }
  return head;
}

void printLinkedList(Node* head) {
  if (head == NULL) {
    cout << "empty list" << endl;
    return;
  }
  Node* p = head;
  while(p != NULL) {
    cout << p->value << " -> ";
    p = p->next;
  }
  cout << "NULL" << endl;
}

int main(){
  int values[] = {4, 4, 4, 1, 2, 5};
  int length = sizeof(values) / sizeof(int);
  Node* l1 = createLinkedList(values, length);
  printLinkedList(l1);
  Node* newHead = removeNode(l1, 4);
  printLinkedList(newHead);
  return 0;
}