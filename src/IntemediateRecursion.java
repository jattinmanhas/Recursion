import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // 6. Print all subsets without duplicate values
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, nums, new ArrayList<>(), 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> temp, int idx){
        ans.add(new ArrayList<>(temp));

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }

            temp.add(nums[i]);
            backtrack(ans, nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    // 7. Subset Sum
    public void subsetSum(int index, ArrayList<Integer> list, int[] arr, int sum, ArrayList<Integer> ans){
        if(index >= arr.length){
            ans.add(sum);
            return;
        }

        list.add(arr[index]);
        sum += arr[index];
        subsetSum(index + 1, list, arr, sum, ans);

        // backtraking
        sum -= arr[index];
        list.remove(list.size() -1);
        subsetSum(index + 1, list, arr, sum, ans);
    }

    // 8. Combination Sum I (Leetcode)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        solveAns(0, candidates, target, outer, inner);
        return outer;
    }

    public void solveAns(int idx, int[] candidates, int target, List<List<Integer>> outer, List<Integer> inner){
        if(idx == candidates.length || target <= 0){
            if(target == 0){
                outer.add(new ArrayList<>(inner));
            }
            return;
        }

        inner.add(candidates[idx]);
        solveAns(idx, candidates, target-candidates[idx], outer, inner);
        inner.remove(inner.size()-1);
        solveAns(idx+1, candidates, target, outer, inner);

    }

    // 9. Combination Sum II (Leetcode)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        Arrays.sort(candidates);
        solveAnsii(0, candidates, target, outer, inner);
        return outer;
    }

    public void solveAnsii(int idx, int[] candidates, int target, List<List<Integer>> outer, List<Integer> inner){
        if(target == 0){
            outer.add(new ArrayList<>(inner));
        }

        for(int i = idx; i<candidates.length;i++){
            if(i != idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }

            inner.add(candidates[i]);
            solveAnsii(i+1, candidates ,target - candidates[i], outer, inner);
            inner.remove(inner.size() -1);
        }
    }
}
