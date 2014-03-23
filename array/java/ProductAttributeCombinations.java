/*
 * Problem Statment:
  In Amazon web site, the product items has to show with different attributes combination for clothers. 

  Example: 
    color - red blue green 
    size - XL X M S 
    pattern - checks lines 

  so output should be in below format in different combinations: 
  red - xL - checks 
  red - xL - lines 
  red - X - checks 
  red - x - lines 
  red - M - checks 
  : 
  : 
  green - S - checks 
  green - S - lines 
  Note:- In above example, no. of attributes is 3. but attributes can be N. 

  Solution:
    we use a two-dimensional array to store the products:
    { {red, blue, green}, {XL, X, M, S}, {checks, lines}, ... }
    assuming each attribute has up to 4 items.
    using two bit for each attribute, for example
    read - xl - checks can be represented by 00 - 00 - 00 - ...
    read - xl - lines can be represented by 00 - 00 - 01 - ...
    iterate thourgt all 00 to all 11 and out the combination. 
 */

public class ProductAttributeCombinations {

  public static void main(String[] args) {
    String[][] products = { {"red", "blue", "green"}, {"XL", "X", "M", "S"}, {"checks", "lines"} };
    printProductAttributeCombinations(products);
  } 

  public static void printProductAttributeCombinations(String[][] products) {
    if (products == null) return;
    int len = products.length;
    int[] indexes = new int[len];
    // using long to prevent overflow
    // be careful with the operator priority, << is very low
    long end = (1 << 2 * len) - 1; // 11 11 11 11 ... case
    for (long i = 0; i <= end; i++ ) {
      boolean allIndexExist = true;
      for (int j = len - 1; j >= 0; j--) {
        // bitwise operation, e.g. to get the second 01 of 01 01 11, do the following:
        // 01 01 11 >> 2 = 01 01, and 01 01 & 00 11 (which = 3) = 00 01 
        int item = (int)(i >> (j * 2)) & 3;
        if (products[len-1-j].length > item) {
          indexes[len-1-j] = item;
        } else {
          allIndexExist = false; // ignore this combination if the item does not exist.
          break;
        }
      }
      if (allIndexExist) { // print the combination
        for (int k = 0; k < indexes.length; k++) System.out.print(products[k][indexes[k]] + " - ");
        System.out.println();
      }
      for (int k = 0; k < indexes.length; k++) indexes[k] = 0; // reset index array
    }
  }
}
