/**
 * Problem statement:
 * Given an integer, determine if it is a palindrome.
 * example: 12321 is a palindrome integer.
 */

public class IntegerPalindrome {
 
  public static void main(String[] args) {
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(2882));
    System.out.println(isPalindrome(2342));
  } 
  
  // 1221
  public static boolean isPalindrome(int a) {
    if (a < 0) return false; // negative number is not palindrome.
    int left = 1; // the leftmost digit
    while (left * 10 < a) left *= 10;
    int temp = a; // remains the integer we need to check
    while (temp > 0 && left > 1) {
      int l = temp / left; // get first digit
      int r = temp % 10;   // get last  digit
      if (l != r) return false;
      temp = temp / 10;    // drop last digit
      temp = temp % (left / 10); // drop first digit
      left /= 100;
    }
    return true;
  }
}
