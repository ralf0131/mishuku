/*
  Problem statement: 
    Write a function to find all the combinations of three numbers that sum to zero 
  Sample input:
    1, -2, -1, 3, 0
  Sample output:
    (1, -1, 0), (-2, -1, 3)
  Solution:
    First sort the array, and for each x in array, using two pointer to find a, b
    such that a + b = -x
    Using HashSet to avoid duplication.
 */
import java.util.*;

public class FindThreeNumSumToZero {

  public static void main(String []args) {
    int[] arr = { 1, -2, -1, 3, 0 };
    int[] arr2 = {2, 3, 1, -2, -1, 0, -3};
    findSumToZero(arr2);
  }

  public static void findSumToZero(int[] arr) {
    if (arr == null || arr.length == 0) return;
    Arrays.sort(arr);
    Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
    for (int i = 0; i < arr.length; i++) {
      int start = 0;
      int end = arr.length - 1;
      int localSum = -arr[i];
      while (start < end) {
        if (start == i) start++;
        else if (end == i) end--;
        if (arr[start] + arr[end] > localSum) end--;
        else if (arr[start] + arr[end] < localSum) start++;
        else {
          Integer[] res = new Integer[]{arr[i], arr[start], arr[end]};
          Arrays.sort(res);
          resultSet.add(Arrays.asList(res));
          //System.out.println(arr[i] + " + " + arr[start] + " + " + arr[end] + " = 0");
          start++; // don't break, in order to cover all the case
        }
      }
    }
    for (List<Integer> r : resultSet) {
      for (Integer i : r) System.out.print(i + ", ");
      System.out.println();
    }
  }
}

