#include <iostream>
using namespace std;
 
class Node {
  public:
    int value;
    Node* next;
    Node(int v) { value = v; next = NULL; }
};

Node* reverse_recursive(Node* head) {
  if (head == NULL) return NULL;
  Node* cur = head;
  Node* pos = head->next;
  cur->next = NULL;
  if (pos == NULL) return cur;
  Node* h = reverse_recursive(pos);
  pos->next = cur;
  return h;
}

// 10   ->  5   <-  8
// head     pos     h
Node* reverse_recursive2(Node* head) {
  if (head == NULL || head->next == NULL) return head;
  Node* pos = head->next;
  head->next = NULL;
  Node* h = reverse_recursive2(pos);
  pos->next = head;
  return h;
}
 
Node* reverse(Node* head) {
  if (head == NULL) return NULL;
  if (head->next == NULL) return head;
  Node* p1 = head;
  Node* p2 = p1->next;
  Node* p3 = p2->next;
  p1->next = NULL;
  while (p3 != NULL) {
    p2->next = p1;
    p1 = p2;
    p2 = p3;
    p3 = p2->next;
  }
  p2->next = p1;
  return p2;
}

//       10  ->  5   -> 8
// prev  cur    pos
Node* reverse2(Node* head) {
  if (head == NULL) return NULL;
  Node* cur = head;
  Node* prev = NULL;
  Node* pos = NULL;
  while (cur != NULL) {
    pos = cur->next;
    cur->next = prev;
    prev = cur;
    cur = pos;
  }
  return prev;
}
 
void traverse(Node* head) {
  // check special case
  if (head == NULL) return;
  Node* cur = head;
  while (cur != NULL) {
    cout << cur->value << ", ";
    cur = cur->next;
  }
  cout << "\n";
}
 
int main() {
  Node* n1 = new Node(6);
  Node* n2 = new Node(5);
  Node* n3 = new Node(8);
  Node* n4 = new Node(9);
  Node* n5 = new Node(7);
  n1->next = n2;
  n2->next = n3;
  n3->next = n4;
  n4->next = n5;
 
  traverse(n1);
  traverse(reverse(n1));
  reverse(n5);
  traverse(reverse2(n1));
  reverse2(n5);
  traverse(reverse_recursive(n1));
  reverse_recursive(n5);
  traverse(reverse_recursive2(n1));
  reverse_recursive2(n5);
  return 0;
}
