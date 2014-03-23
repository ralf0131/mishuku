/**
 * An integer array contains elements in increasing order till some point,
 * and then in decreasing order, return the index of maximum number. 
 * Solution should be less than O(n).
 * Ex - {1, 2, 3, 4, 5, 3, 1}, output should be 4(index of mamimum number 5)
 */

public class FindMaxFromIncDecArray {

  public static void main(String []args) {
    int[] arr = {1, 2, 3, 4, 5, 3, 1};
    int[] arr2 = {1, 4, 5, 6};
    int[] arr3 = {9, 5, 3};
    System.out.println(findMax(arr));
    System.out.println(findMax(arr2));
    System.out.println(findMax(arr3));
  }

  public static int findMax(int[] arr) {
    return findMaxHelper(arr, 0, arr.length-1);
  }

  // using concept like a binary search
  // this solution can only deal with there is no duplicates.
  public static int findMaxHelper(int[] arr, int start, int end) {
    if (start < 0 || end < 0 || start > end) return -1; // invalid
    if (start == end) return start;
    int mid = start + (end - start) / 2;
    if (arr[mid] > arr[mid+1]) return findMaxHelper(arr, start, mid);
    if (arr[mid] < arr[mid+1]) return findMaxHelper(arr, mid+1, end);
    return -1; // one time appear twice.
  }

  // TODO tenary search
}
