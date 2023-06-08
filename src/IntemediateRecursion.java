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
}
