import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        // write your code here

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0;i < numbers.length;i++){
            numbers[i] = rand.nextInt(1000);

        }

        System.out.println("Before:");
        printArray(numbers);

        quickSort(numbers,0,numbers.length-1);

        System.out.println("\nAfter:");
        printArray(numbers);

    }

    /*
    * so in  qiuck sort we choose the last value in our array to be our pivot
    * the values smaller than the pivot value go in a left array
    * and values bigger go into a right array
    * this keep happeniong till the array is sorted
    *
    * */

    private static void quickSort(int[] array, int LowIndex,int HighIndex){

        if(LowIndex >= HighIndex){
            return;
        }

        int pivot = array[HighIndex];

        int leftPointer = LowIndex;
        int rightPointer = HighIndex;

        //so here we have two pointers one of them at the start of array
        //the other at the end and we are gonna go trhough ther array and compare each value to the pivot

        while(leftPointer < rightPointer){

            //so
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }

            swap(array,leftPointer,rightPointer);

        }
        //swaps the pivot as the two pointers are on the same value
        swap(array,leftPointer,HighIndex);

        //needs to be done recusively so
        quickSort(array,LowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,HighIndex);

    }

    private static void swap(int [] array, int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }



    private static void printArray(int[] numbers){
        for (int i = 0; i<numbers.length;i++){
            System.out.println(numbers[i]);
        }

    }
}
