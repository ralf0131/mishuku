/**
 Given an array of integers, for each integer,
 find the nearest larger number to its right.
 If there is no number larger than itself, return itself.
 e.g. Input array:  {2, 4, 7,  5,  10, 12, 6, 1}
      Output array: {4, 7, 10, 10, 12, 12, 6, 1}
 Solution:
   scan from right to left, using a stack to store all the numbers that
   is larger than the current one in ascending order.
   Each time update the stack by discarding all numbers that are less than it.
 */

import java.util.LinkedList;

public class FindNearestLargerNumberToTheRight {

  public static void main(String[] args) {
    int[] arr = {2, 4, 7, 5, 10, 12, 6, 1};
    print(arr);
    int[] res = findNearestLargerNumberToTheRight(arr);
    print(res);
  } 

  public static int[] findNearestLargerNumberToTheRight(int[] arr) {
    assert(arr.length >= 0);
    LinkedList<Integer> largerNumbers = new LinkedList<Integer>();
    int[] result = new int[arr.length];
    for (int i = arr.length-1; i >= 0; i--) {
      // find out the correct position to put
      while (!largerNumbers.isEmpty()) {
        int n = largerNumbers.peek();
        if (n < arr[i]) largerNumbers.pop(); // discart number that < arr[i]
        else {
          result[i] = n; // find the result
          break;
        }
      }
      if (largerNumbers.isEmpty()) result[i] = arr[i]; // no number is > arr[i]
      largerNumbers.push(arr[i]); // put arr[i] into the head of linked list 
    }
    return result;
  }

  public static void print(int[] arr){
    for (int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
    System.out.println("END");
  }

}
