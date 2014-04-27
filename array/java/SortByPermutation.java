/**
  The input is a sequence x1,x2,...,xn of integers in an arbitrary order, and another sequence 
  a1,a2,..,an of distinct integers from 1 to n (namely a1,a2,...,an is a permutation of 
  1, 2,..., n). Both sequences are given as arrays. Design an 0(n logn) algorithm to order 
  the first sequence according to the order imposed by the permutation. In other words, for 
  each i, Xi should appear in the position given in ai.
  For example, if x = 17, 5, 1,9, and a = 3, 2, 4, 1, then the outcome should be x = 9, 5, 17, 1.
  The algorithm should be in-place, so you cannot use an additional array.
 */

public class SortByPermutation {
  
  public static void main(String []args) {
    int[] arr = {17, 5, 1, 9};
    int[] perm = {3, 2, 4, 1};
    int[] result = sortByPermutation(arr, perm);
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ", ");
    System.out.println();
  }

  /*
     test cases: 
     arr = null, perm = null
     arr = null, perm != null
     arr != null, perm = null
     arr.length != perm.length
     correct input
     perm contains invalid numbers: perm[i] > arr.length
   */
  public static int[] sortByPermutation(int[] arr, int [] perm) {
    assert(arr != null && perm != null && arr.length != perm.length);
    for (int i = 0; i < arr.length; i++) {
      // swap arr[i] and arr[perm[i]-1]
      swap(arr, i, perm[i]-1);
      // swap perm[i] and perm[perm[i]-1]
      swap(perm, i, perm[i]-1);
    }
    return arr;
  }

  public static void swap(int[] arr, int A, int B) {
    assert(arr != null && A >= 0 && A < arr.length && B >= 0 && B < arr.length);
    if (A == B) return;
    int temp = arr[A];
    arr[A] = arr[B];
    arr[B] = temp;
  }

}
