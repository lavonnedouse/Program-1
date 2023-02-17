import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ArrayApp_NumberFreq
{
    public static void main() throws FileNotFoundException{
        String inputFile = "";
        System.out.print("Input File: ");
        int [] array = readValuesFromFile(inputFile);
        //normal array is already being called here

        //convert freqarray(this is where array is called)
        System.out.print("Original Frequency Array: ");
        System.out.println();
        int [] freqarray = convertFreqArray(array);
        System.out.println();

        System.out.print("Normalized Bar Chart: ");   
        freqarray = normalizeArray(freqarray);
        System.out.println();
        printBarChart(freqarray);
        // your work here

        return;
    }

    /*
     * Read a sequence of non-negative integers from an input file, and 
     * save them in an array.
     * 
     * Important: the first number is used to for the array size, 
     *            this number should NOT be included in the array
     * 
     * e.g, in your input file(numbers_20_5.txt):
     * 20 1 4 3 4 1 3 3 0 2 4 0 4 3 4 4 2 0 3 4 0 
     * you need to create an array with the size of 20
     */
    public static int [] readValuesFromFile(String inputFile) throws FileNotFoundException
    {
        // your work here
        int [] array;

        Scanner scan = new Scanner(System.in);

        File myfile = new File(scan.nextLine());

        Scanner scan2 = new Scanner(myfile);

        array = new int[scan2.nextInt()];
        while(scan2.hasNextInt()) {
            for(int i = 0; i < array.length; i++) {
                array[i]= scan2.nextInt();
            }
        } 
        return array;

    }

    /* DO SECOND
     * Build a frequency array based on your input array
     * 
     * e.g,
     * input array (arr): 1 4 3 4 1 3 3 0 2 4 0 4 3 4 4 2 0 3 4 0
     * frequncy array (freqA): 4 2 2 5 7 
     * Explanation: freqA[0]=4, freqA[1]=2,... 
     * 
     * Hint: 
     *      you need to find the largest element in the array first, and 
     *      use this to create a frequeny array with the size of largest+1
     *      in the above example, 4 (largest), so freqArray size is 4+1=5
     *      Now you are ready to count how many 0, how many 1,....
     */
    public static int[] convertFreqArray(int [] arr) {
        //CALL LARGEST METHOD IN ORDER TO GET THE ARRAY SIZE

        int largest = largestInArray(arr);
        int [] freqArray = new int[largest+1];
        int count = 0;
        int currentInt = 0; 

        // for(int i = 0; i < freqArray.length; i++) {
        // freqArray[i] = 0; } 
        // Second thing to do: Count the frequency/how many times each number appears

        for(int i = 0; i < freqArray.length; i++){
            freqArray[i] = 0;

            for(int j= 0;j < arr.length; j++){

                if(i == arr[j]){                  
                    count++;
                }               
            } 
            if(freqArray[i] == currentInt){  
                freqArray[i] = count;                 
                count = 0;
                //could use temp integer and a for loop; use a nested loop; use an IF statement to compare integers
                //your work here

                // }
            }
        } 
        int [] countArray = freqArray;
        printFreqArr(countArray);
        return freqArray;

    }

    /** Print the letters, their frequencies, and bar representation with *
    // * 
    // * e.g:
    // * Input frequency array: 11  5  5 14 20 
    // * Normalized Array Barchart: 
    // * 0 ( 11): ***********
    // * 1 (  5): *****
    // * 2 (  5): *****
    // * 3 ( 14): **************
    // * 4 ( 20): ********************
    // */
    public static void printBarChart(int [] countArray) {
        // your work here
        for(int i = 0; i < countArray.length ; i++) {
            int count = countArray[i];
            
             System.out.printf("%-3d( %-3d): ",i, count);
            for (int j = 0; j < count; j++) {
               
                System.out.print("*");
            }
            System.out.println();
        } 

    }

    /**
     * Print out the all number: frequency pair for any given freqArr
     * 
     * e.g:
     * Input frequncy array (freqA): 4 2 2 5 7 
     * Explanation: freqA[0]=4, freqA[1]=2,...
     * 
     * Printout should be as follows: 
     *  0:  4
     *  1:  2
     *  2:  2
     *  3:  5
     *  4:  7
     */

    public static void printFreqArr(int [] countArray) {
        //your work here

        for (int i = 0; i < countArray.length; i++){
            System.out.println(i + ":" + countArray[i]);
        }
    }

    /*
     * return a string representation of "*" corresponding to the input count. 
     * For instance, if count = 5, then you should return "*****"
     * 
     * Note: This method will be invoked in the method of printBarChart()
     */
    public static String numToStar(int count) {

        for(int i = 0; i < count ; i++) {
            System.out.print("*");
            //your work here

        }
        return "";
    }

    /**  DO THIS ONE FIRST
     * Find the largest value in the array, and return it
     *  e.g, 
     *  input array (arr): 1 4 3 4 1 3 3 0 2 4 0 4 3 4 4 2 0 3 4 0 #largest: 4
     *  Frequency array:    4  2  2  5  7 #largest: 7
     */
    public static int largestInArray(int [] arr) {
        int largest = arr[0];
        for ( int i = 0; i < arr.length; i++ ) {
            if(arr[i] > largest ) {
                largest = arr[i];
            }
        }
        //your work here
        return largest;
    }

    /** 
     * Normalize the orignal frequency array so that the largest element 
     * is scaled to 20, and the remaining elements will be scaled to
     * arr[i]*20/largest (note, we truncate the fraction part)
     * 
     * e.g,
     * Original Frequency Array:    4  2  2  5  7 
     * Normalized Frequency Array: 11  5  5 14 20 
     */
    public static int [] normalizeArray(int [] arr) {
        // your work here

        int [] normarr = new int[arr.length];

        int largest;
        largest = largestInArray(arr);
        for(int i = 0;i < arr.length ; i++) {
            normarr[i] = (arr[i] * 20 )/ largest;
        }
        return normarr;
    } 
}