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
    System.out.println(isPalindrome(0));
    System.out.println(isPalindrome(Integer.MAX_VALUE));
    System.out.println(isPalindrome(Integer.MIN_VALUE));
  } 
  
  // 1221
  public static boolean isPalindrome(int a) {
    if (a < 0) return false; // negative number is not palindrome.
    long left = 1L; // the leftmost digit, using long to prevent overflow
    while (left * 10 < a) left *= 10;
    long temp = a; // remains the integer we need to check
    while (temp > 0 && left > 1) {
      long l = temp / left; // get first digit
      long r = temp % 10;   // get last  digit
      if (l != r) return false;
      temp = temp / 10;    // drop last digit
      temp = temp % (left / 10); // drop first digit
      left /= 100;
    }
    return true;
  }
}
