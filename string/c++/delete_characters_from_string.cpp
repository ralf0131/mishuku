/**
 Given a char array A, remove all chars that appears in char array B.
 */

#include <iostream>
using namespace std;

char* deleteChars(char* src, const char* toBeDelete) {
  if (src == NULL) return NULL;
  if (toBeDelete == NULL) return src;
  bool hashTable[256];
  memset(hashTable, false, 256);
  const char* p = toBeDelete;
  while (*p != '\0') {
    hashTable[*p] = true;
    p++;
  }
  int start = 0;
  int end = 0;
  while (src[start] != '\0') {
    while (hashTable[src[end]]) end++;
    src[start++] = src[end++];
  }
  return src;
}

int main() {
  char src[] = "I am a good man.";
  cout << "before: " << src << endl;
  cout << "after: " << deleteChars(src, "mdg") << endl;
  return 0;
}
