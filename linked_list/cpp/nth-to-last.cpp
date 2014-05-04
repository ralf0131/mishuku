#include <iostream>
using namespace std;

class Node {
  public:
    int value;
    Node* next;
    Node(int v) { value = v; next = NULL; }
};

Node* nthToLast(Node* head, int n) {
  // return NULL for non-positive n, or the head pointer is null
  if (n <= 0 || head == NULL) return NULL;
  Node* p = head;
  Node* cur = head;
  // move p n-1 steps first
  int nsteps = 0;
  while (p != NULL && nsteps < n) {
    p = p->next;
    nsteps++;
  }
  // return NULL if n is larger than the length of list
  if (nsteps < n) return NULL;
  // move p and cur together
  while (p != NULL) {
    p = p->next;
    cur = cur->next;
  } 
  return cur;
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
  cout << nthToLast(n1, 1)->value << endl;
  cout << nthToLast(n1, 3)->value << endl;
  cout << nthToLast(n1, 5)->value << endl;
  cout << nthToLast(n1, 10) << endl;
  return 0;
}
