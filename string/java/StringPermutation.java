/**
 * Problem statement:
 * Given an array of chars, output all the permutations.
 * e.g. input: a, b, c
 * output: # of permutation shoule be n! 
 *   a, b, c
 *   a, c, b
 *   b, a, c
 *   b, c, a
 *   c, a, b
 *   c, b, a
 */

public class StringPermutation {
  
  public static void main(String[] args) {
    char[] arr = {'a', 'b', 'c', 'd'};
    StringPermutation(arr);
  }

  public static void StringPermutation(char[] arr){
   StringPermutationHelper(arr, 0); 
  }

  public static void StringPermutationHelper(char[] arr, int start) {
    assert(arr.length > 0 && start >= 0);
    if (start == arr.length) {
      for (int i = 0; i < arr.length; i++) System.out.print(arr[i]);
      System.out.println();
      return;
    }
    for (int i = start; i < arr.length; i++) {
      swap(arr, start, i);
      StringPermutationHelper(arr, start+1);
      swap(arr, start, i);
    }
  }

  public static void swap(char[] arr, int a, int b) {
    assert(arr != null && a >= 0 && b >= 0 && a < arr.length && b < arr.length);
    if (a == b) return; // avoid unnecessary swap
    char temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

}
