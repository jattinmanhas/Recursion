import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FirstSet fs = new FirstSet();
        int arr[] = {1,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<>();
//        fs.printName5Times("Jattin", 5);
//        fs.printLinearlyFrom1ToN(8);
//        fs.printFromNto1(6);
//        fs.printSumNSum(1, 0, 5);
//        System.out.println(fs.printReturnSum( 5));
//        System.out.println(fs.factorial(5));
//        fs.reverseArray(arr, 0, list);
//        System.out.println(list);
//        fs.reverseSwapArray(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(fs.reverseString("Night"));
//        System.out.println(fs.isSorted(arr, 0));
//        System.out.println(fs.reverseNumber(1234));
//        System.out.println(fs.power(2,4));

        int[] array = {3,1,2};
        int[] nums = {8,3,62,1,616,71,1};
        SortingRecursion sr = new SortingRecursion();
//        System.out.println(sr.LinearSearch(array, 0, 5));
//        sr.linearSearchArrayList(array, 0, 5, list);
//        System.out.println(list);
//        System.out.println(sr.binarySearch(array, 0, arr.length-1, 8));
//        System.out.println(sr.rotatedBinarySearch(array, 0, array.length-1, 5));
//        sr.bubbleSort(nums, nums.length-1, 0);
//        System.out.println(Arrays.toString(nums));
//        sr.selectionSort(nums, nums.length, 0, 0);
//        System.out.println(Arrays.toString(nums));

        IntemediateRecursion ir = new IntemediateRecursion();
//        ir.printStarPattern(5,0);
//        System.out.println(ir.triangularSum(nums));
        ir.printSubsequences(0, list, array);
    }
}