/**
Problem Description

You are given an array of integers with values greater than or equal to 0, for example:

[5, 6, 0, 4, 2, 4, 1, 0, 0, 4]

You will develop and implement an algorithm to traverse the array in the shortest number of “hops” starting at index 0, where traversal is defined as follows:

Start at the first (0th) index of the array, look at the array value there, and you can hop forward to any array index that is no farther than that value away. So in this example, you start at index 0 containing the value 5 and can now consider hopping to any of indices 1 through 5 inclusive.
If you choose to hop to index 3, it contains the value 4 and you can next hop up to 4 more spots from your current index (3)—so you now consider indices 4 through 7 as next steps in your sequence.
Once you can legally hop beyond the last array element, you have successfully traversed the array.
Your job is to compute the minimum-length sequence of hops that successfully traverses the array starting from index 0, or determine that there is no such sequence.

Your algorithm must identify a minimum-hops solution, but can choose arbitrarily among solutions with the same number of hops.

Your program will implement the algorithm and write a solution to the standard output stream on a single line identifying the array indices that comprise a solution path, with the indices separated by commas.

For this example, the following would be valid output:

0, 5, 9, out
 */

public class ArrayHopper {

  public static void main(String[] args) {
    int[] arr = {5, 6, 0, 4, 2, 4, 1, 0, 0, 4};
    System.out.println(onlyOutputMinStepsRecursive(arr, 0));
    System.out.println(onlyOutputMinStepsNonRecursive(arr, 0));
  }

  public static int onlyOutputMinStepsRecursive(int []arr, int start) {
    // do some check
    if (arr == null || start < 0 || start >= arr.length) return -1; // as error code
    if (start == arr.length-1) return 0; // recursion end condition

    int min = arr.length;
    // recursion body
    for (int i = start+1; i <= start+arr[start]; i++) {
      int temp = onlyOutputMinStepsRecursive(arr, i);
      min = Math.min(temp, min);
    }
    return min+1;
  }

  // O(n^2) time, O(n) space
  public static int onlyOutputMinStepsNonRecursive(int[] arr, int start) {
    // do some check
    if (arr == null || start < 0 || start >= arr.length) return -1; // as error code
    int[] hopArr = new int[arr.length];
    hopArr[hopArr.length-1] = 0; // last element as initial condition
    for (int k = 0; k < hopArr.length-1; k++) hopArr[k] = arr.length;
    for (int i = arr.length-2; i >= start; i--) {
      int min = arr.length;
      for (int j = i+1; j <= i+arr[i]; j++) {
        min = Math.min(min, hopArr[j]);
      }
      hopArr[i] = min+1;
    }
    return hopArr[start];
  }

  
}
