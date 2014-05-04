#include <iostream>
using namespace std;

class Node {
  public:
    int value;
    Node* next;
    Node(int v) { value = v; next = NULL; }
};

bool isLoop(Node* head) {
  if (head == NULL) return false;
  Node* fast = head;
  Node* slow = head;
  while (fast != NULL && fast->next != NULL) {
    fast = fast->next->next;
    slow = slow->next;
    if (fast == slow) return true;
  }
  return false;
}

// Proof: suppose
// 0. fast pointer moves twice as fast as slow pointer.
// 1. it will need m steps from head node to loop entry node.
// 2. it will need d steps from entry node to come across node.
// 3. slow pointer moves s circles in the loop.
// 4. fast pointer moves t circles in the loop.
// 5. circle length is l.
// At the time they meet,
// slow pointer has moved (m + d + sl) steps
// fast pointer has moved (m + d + tl) steps
// because fast pointer moves twice fast, we have
// 2*(m + d + sl) = m + d + tl, which will lead
// m = (t-s)l - d
// Now we proov that if we move the slow pointer m steps,
// it will be eventually reach the loop entry node.
// slow pointer already moved (m + d + sl) steps,
// if it moves m steps further, which will be
// m + d + sl + m 
// = m + d + sl + (t-s)l - d 
// = m + tl
// which will reach the entry node.
Node* findLoopEntry(Node* head) {
  if (head == NULL) return NULL;
  Node* fast = head;
  Node* slow = head;
  // fast moves twice as fast as slow
  while (fast != NULL && fast->next != NULL) {
    fast = fast->next->next;
    slow = slow->next;
    if (fast == slow) break;
  }
  // no loop exist
  if (fast == NULL || fast->next == NULL) return NULL;
  Node* p = head;
  // the two pointer will eventually meet.
  while (p != fast) {
    p = p->next;
    fast = fast->next;
  }
  return p;
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
  n5->next = n2;
  cout << isLoop(n1) << endl;
  cout << findLoopEntry(n1)->value << endl;
  return 0;
}
