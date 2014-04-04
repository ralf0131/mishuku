/**
 Problem statement:
 Given a phone number to letters map, and an array of numbers.
 Output all possible letter combinations the numbers can represent.
 e.g. input 2, 3
 output: AD, AE, AF, BD, BE, BF, CD, CE, DF
 */


#include <iostream>
using namespace std;

char num2letter[10][5] = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

void number2words(int numbers[], int result[], int start, int len) {
  if (start < 0 || len < 0 || start > len) return;
  if (start == len) {
    for (int i = 0; i < len; i++) cout << num2letter[numbers[i]][result[i]];
    cout << endl;
  }

  char* letters = num2letter[numbers[start]];
  for (int i = 0; letters[i] != '\0'; i++) {
    result[start] = i;
    number2words(numbers, result, start+1, len);
  }

}

int main() {
  int numbers[] = { 2, 3, 6, 8, 9 };
  int result[] = { 0, 0, 0, 0, 0 };
  int len = sizeof(numbers) / sizeof(int);
  number2words(numbers, result, 0, len);
  return 0;
}
