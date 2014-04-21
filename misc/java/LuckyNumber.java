/*
  Lucky number – a number is a lucky number if it comprises of combination of 4′s and 7′s. 

  For example , if 32 is the input number, the next nearest lucky number would be 44. 

  Similarly , 
    43 -> 44 
    45 -> 47 
    1004 -> 4444 

  Input number can be of any digits. 

  Design an algorithm that will take any random number and return its next lucky number

  Solution: using 0 to represent 4, 1 to represent 7.
    say x is n digit iterate from 00..0(n digits) to 11..1(n digits),
    and convert binary to lucky number and compare to x
    if no number is larger than x, increase one digit add test again.
 */

public class LuckyNumber {
  
  public static void main(String []args) {
    System.out.println(nextLuckyNumber(43));
    System.out.println(nextLuckyNumber(45));
    System.out.println(nextLuckyNumber(77));
    System.out.println(nextLuckyNumber(4524));
    System.out.println(nextLuckyNumber(1004));
    System.out.println(nextLuckyNumber(45532));
  }

  public static int nextLuckyNumber(int x) {
    int digits = 0;
    for (int n = x; n > 0; n /= 10) digits++;
    // start from the digit of x
    while (true) {
      for (int i = 0; i < (1 << digits); i++) {
        int lucky = 0;
        // generate candidate lucky number and compare with x
        for (int k = digits - 1; k >= 0; k--) {
          if (((1 << k) & i) == 0) lucky = lucky * 10 + 4;
          else lucky = lucky * 10 + 7;
        }
        if (lucky > x) return lucky;
      }
      digits++;
    }
  }

}
