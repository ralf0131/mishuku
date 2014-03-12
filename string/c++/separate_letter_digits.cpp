/**
 * Problem statement:
 * You are given a string which has numbers and letters.
 * Numbers occupy all odd positions and letters even positions.
 * You need to transform this string such that:
 * 1. all letters move to front of array, and all numbers at the end.
 * 2. the relative order of the letters and numbers needs to be preserved.
 * eg: a1b2c3d4 -> abcd1234 , x3y4z6 -> xyz346
 */
#include <iostream>
using namespace std;

bool isDigit(char s) {
  return s >= '0' && s <= '9';
}

bool isLetter(char s) {
  return (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
}

// operate with pointers
// works like insertion sort.
// move digit from front to back to their proper position.
char* separateLettersAndDigits1(char* s) {
  if (!s) return NULL;
  int len = strlen(s);
  if (len < 2) return s;
  char* last = s + len - 1;
  char* secLast = last - 1;
  char temp = 0;
  while (secLast != s) {
    while (isLetter(*secLast)) secLast--;
    if (secLast < s) break;
    // copy letter backwards
    temp = *secLast;
    for (char* t = secLast + 1; t != last; t++) {
      *(t - 1) = *t;
    }
    *(last - 1) = temp;
    last--;
  }
  return s;
}

// operate with offset
// move letter from back to front to their proper position.
char* separateLettersAndDigits2(char* s) {
  if (!s) return NULL;
  int len = strlen(s);
  int i = 0; // point to the current moved letter
  int j = 1; // point to the next letter to move
  while (j < len - 1) {
    while (isDigit(s[j]) && j < len - 1) j++; // find the next letter to move
    if (j >= len - 1) break;
    int temp = s[j];
    for (int k = j - 1; k > i; k--) s[k + 1] = s[k]; // copy the digits backwards
    s[i + 1] = temp; // move the letter to proper position
    i++; // prepare for next move
    j = i + 1;
  }
  return s;
}

int main() {
  char s[] = "a1b2c3d4e5f6g7h8";
  char s2[] = "abc123defgh4i5j6";
  cout << "Original: " << s << endl;
  cout << "Transformed1: " << separateLettersAndDigits1(s) << endl;
  cout << "Transformed2: " << separateLettersAndDigits2(s) << endl;
  cout << "Original: " << s2 << endl;
  cout << "Transformed1: " << separateLettersAndDigits1(s2) << endl;
  cout << "Transformed2: " << separateLettersAndDigits2(s2) << endl;

  return 0;
}
