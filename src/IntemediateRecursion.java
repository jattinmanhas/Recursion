import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

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

    // 10. print all permutation of the string...
    public void permutationsString(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0;i<=p.length();i++){
            String first = p.substring(0,i);
            String last = p.substring(i, p.length());
            permutationsString(first+ch+last, up.substring(1));
        }
    }

    // 11. Permutations Array
    public List<List<Integer>> permutationArray(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        permute(0, arr, outer);
        return outer;
    }

    public void permute(int index, int[] arr, List<List<Integer>> outer){
        if(index == arr.length){
            ArrayList<Integer> inner = new ArrayList<>();
            for(Integer in : arr){
                inner.add(in);
            }
            outer.add(new ArrayList<>(inner));
            return;
        }

        for(int i = index; i<arr.length;i++){
            swapcoll(i, index, arr);
            permute(index+1, arr, outer);
            swapcoll(i, index, arr);
        }

    }
    public void swapcoll(int i,int j,int[]nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    // 12. Print Phone numbers part 1. => a starts from 1 and each number contains 3 numbers....
    // 1 -> abc, 2 -> def, 3 -> ghi ...... 9 -> yz
    public void printPhoneLetters(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for(int i = (digit - 1)*3; i< digit * 3; i++){
            if(i==26){
                continue;
            }
            char ch  = (char)('a' + i);
            printPhoneLetters(p+ch, up.substring(1));
        }
    }

    // part 2: letter combination of the phone number
    List<String> mapping = new ArrayList<>(List.of("", "", "abc","def","ghi","jkl", "mno","pqrs","tuv","wxyz"));
    public List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }

        generateCombinations(digits, "", 0, ans);
        return ans;
    }

    public void generateCombinations(String digits, String p, int index, List<String> ans){
        if(index == digits.length()){
            ans.add(p);
            return;
        }

        String currentDigit = mapping.get(digits.charAt(index) - '0');
        for(int i = 0;i<currentDigit.length(); i++){
            generateCombinations(digits, p+currentDigit.charAt(i), index +1, ans);
        }
    }

    // 13. Count path in the maze leading to the destination
    public int countMazePath(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = countMazePath(r-1, c);
        int right =  countMazePath(r, c-1);

        return left + right;
    }

    // 14. print all the paths to the destination...
    public void printMazePath(String path,int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path +  "("+r+","+c+")");
            return;
        }
        if(r > 1){
            printMazePath(path + "("+r+","+c+")" ,r-1, c);
        }
        if(c > 1){
            printMazePath(path + "("+r+","+c+")" ,r,c-1);
        }
    }

    // 15. all routes to destination in maze by moving in horizontal, vertical and diagonal direction
    public void diagonalPathMaze(String path, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }
        if(r> 1){
            diagonalPathMaze(path + "H", r-1, c);
        }
        if(c > 1){
            diagonalPathMaze(path + "V", r , c-1);
        }
        if(r > 1 && c > 1){
            diagonalPathMaze(path+ "D", r-1, c-1);
        }
    }
}
