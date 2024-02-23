public class BinarySearch {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5,6,7,8,9,11};

        System.out.println(binarySearch(numbers,6));

    }

    private static int binarySearch(int[] sortedNumbers, int numberToFind){
        int leftPointer = 0;
        int rightPointer = sortedNumbers.length-1;



        while(leftPointer <= rightPointer){
            int middleIndex = (leftPointer + rightPointer)/2;
            int middleNumber = sortedNumbers[middleIndex];

            if (numberToFind == middleNumber){
                return middleIndex;
            }

            if(numberToFind < middleNumber){
                rightPointer = middleIndex -1;
            }
            else{
                leftPointer = middleIndex +1;
            }
        }

        return -1;
    }
}
