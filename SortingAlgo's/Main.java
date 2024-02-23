import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0;i < numbers.length;i++){
            numbers[i] = rand.nextInt(1000000);

        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);

    }

    /*
     * so essentailly divide and conquer step1:
     * keep splitting the array in half till it reaches less than 2 vcaraibles in the array (so omnly 1 variable)
     * then compare this one varaible in (left array) with the the one next to it (right array)
     * and add the smallest opne to the new mergearray, then add the other one
     * keep doing this using recursion to get sorted list e.g mergesort(leftarray); mergesort(rightarray)
     *
     * */

    private static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;
        int midPoint = inputLength/2;

        if(inputLength <2){
            return;
        }

        int[] leftHalf = new int [midPoint];
        int[] rightHalf = new int [inputLength - midPoint];

        //need to populate these arrays so i actually split it

        for(int i = 0; i < midPoint;i++){
            leftHalf[i] = inputArray[i];
        }

        for(int i = midPoint; i < inputLength;i++){
            rightHalf[i - midPoint] = inputArray[i];
        }

        //so above splits and makes our twoi arrays
        //then recursive behaviour below to keep splitting arrays until < 2 eleemtns in array

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray,leftHalf,rightHalf);

    }

    private static void merge(int [] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //where we gonna loop trhoiugh elements in left and right arrays from lowest to highedst as they are sorted now
        //compare the first elements of each and adding the lower one to the new merged array
        //so we need 3 interator variables which will walk through the lefthalf array the right half array and mergearray

        int i = 0;
        int j = 0;
        int k = 0;

        while ( i < leftSize && j < rightSize){

            if (leftHalf[i]<= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            }
            else{
                inputArray[k] = rightHalf[j];
                j++;
            }

            k++;
        }
        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;

        }

        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;

        }

    }

    private static void printArray(int[] numbers){
        for (int i = 0; i<numbers.length;i++){
            System.out.println(numbers[i]);
        }

    }

}
