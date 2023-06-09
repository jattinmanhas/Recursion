import java.util.ArrayList;
import java.util.Arrays;

public class IntemediateRecursion {
    // 1. Simple start pattern using recursion
    public void printStarPattern(int row, int col){
        if(row < 1){
            return;
        }

        if(row > col){
            System.out.print("*");
            printStarPattern(row, col + 1);
        }else{
            System.out.println();
            printStarPattern(row -1, 0);
        }
    }

    // 2. print triangular sum of the array....
    public int triangularSum(int[] nums) {
        return triangularSumhelper(nums, 0);
    }

    public int triangularSumhelper(int[] nums, int i){
        if(nums.length == 1){
            return nums[i];
        }

        if(i < nums.length-1){
            nums[i] = (nums[i] + nums[i+1])%10;
            return triangularSumhelper(nums, i+1);
        }
        else{
            int[] newArray = Arrays.copyOfRange(nums, 0, nums.length-1);
            return triangularSumhelper(newArray, 0);
        }
    }

    // 3. Print all subsequences
    public void printSubsequences(int index, ArrayList<Integer> list, int[] arr){
        if(index >= arr.length){
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        printSubsequences(index + 1, list, arr);
        list.remove(list.size() -1);
        printSubsequences(index + 1, list, arr);
    }

    // 4. Printing all the subsequence whose value is equal to k
    public void printSubSum(int index, ArrayList<Integer> list, int[] arr, int sum, int target){
        if(index >= arr.length){
            // checking if target sum is equal to current sum...
            if(sum == target){
                System.out.println(list);
            }
            return;
        }

        list.add(arr[index]);
        sum += arr[index];
        printSubSum(index + 1, list, arr, sum, target);

        // backtraking
        sum -= arr[index];
        list.remove(list.size() -1);
        printSubSum(index + 1, list, arr, sum, target);
    }

    //5. counting all the subsequences whose sum is equal to k....
    public int printCountSum(int index, int[] arr, int sum, int target){
        if(index >= arr.length){
            // checking if target sum is equal to current sum...
            if(sum == target){
                return 1;
            }
            return 0;
        }

        sum += arr[index];
        int l = printCountSum(index + 1, arr, sum, target);

        // backtraking
        sum -= arr[index];
        int r = printCountSum(index + 1, arr, sum, target);

        return l + r;
    }

}
