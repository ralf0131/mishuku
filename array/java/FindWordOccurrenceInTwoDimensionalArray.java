/*
How many occurrences of a given search word can you find in a two-dimensional array of characters,
given that the word can go up, down, left, right, and around 90 degree bends? 

Ex: 
Count of occurrences of SNAKES 
S N B S N 
B A K E A 
B K B B K 
S E B S E 

The answer is 3. 
 */
public class FindWordOccurrenceInTwoDimensionalArray {

    public static void main(String[] args) {
        char[][] arr = {
            {'S', 'N', 'B', 'S', 'N'},
            {'B', 'A', 'K', 'E', 'A'},
            {'B', 'K', 'B', 'B', 'K'},
            {'S', 'E', 'B', 'S', 'E'}
        };
        try {
            System.out.println(findAllOccurence(arr, "SNAKES"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static int findAllOccurence(char[][] arr, String word) throws Exception {
        // do some check
        if (arr == null || arr.length == 0 || word == null) return 0;
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    // we need to start search here
                    count += findWordOccurrenceRecursion(arr, i, j, word, 0);
                }
            }
        }
        return count;
    }
    
    public static int findWordOccurrenceRecursion(char[][] arr, int startRow, int startCol, String word, int wordIndex)
        throws Exception {
        // do some erro check
        if (arr == null || arr.length == 0 || word == null || word.length() <= wordIndex) {
            throw new Exception("bad input."); // as error code
        } 
        if (startRow < 0 || startRow >= arr.length || startCol < 0 || startCol >= arr[startRow].length) {
            throw new Exception("bad input startRow or StartCol"); // as error code
        }
        // recursion end condition
        if (wordIndex == word.length()-1 && word.charAt(wordIndex) == arr[startRow][startCol]) {
            return 1; // because we found an occurrence.
        }
        // recursion body
        if (word.charAt(wordIndex) != arr[startRow][startCol]) {
            return 0; // because character does not match
        }
        int count = 0;
        // continue to search in four direction
        if (startCol <= arr[startRow].length - 2) {
            // search right
            count += findWordOccurrenceRecursion(arr, startRow, startCol+1, word, wordIndex+1);
        }
        if (startRow <= arr.length - 2) {
            // search down
            count += findWordOccurrenceRecursion(arr, startRow+1, startCol, word, wordIndex+1);
        }
        if (startCol >= 1) {
            // search left
            count += findWordOccurrenceRecursion(arr, startRow, startCol-1, word, wordIndex+1);
        }
        if (startRow >= 1) {
            // search up
            count += findWordOccurrenceRecursion(arr, startRow-1, startCol, word, wordIndex+1);
        }
        return count;
    }
}