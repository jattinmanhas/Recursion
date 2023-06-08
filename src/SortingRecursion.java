import java.util.ArrayList;

public class SortingRecursion {
    // 1. Linear Search which returns the first occurrence of the target value.
    public int LinearSearch(int[] arr, int i, int target){
        if(arr.length == i){
            return -1;
        }

        if(arr[i] == target){
            return i;
        }

        return LinearSearch(arr, i+1, target);
    }

    // 2. Linear Search that stores all occurrences of target in an arraylist
    public void linearSearchArrayList(int[] arr, int i, int target, ArrayList<Integer> list){
        if(arr.length == i){
            return;
        }

        // adding element in the arraylist is it is equal to the target value.
        if(arr[i] == target){
            list.add(i);
        }

        // recursive function....
         linearSearchArrayList(arr, i+1, target, list);
    }

    // 3. Binary Search
    public int binarySearch(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid] < target){
            return binarySearch(arr, mid + 1, end, target);
        }
        return binarySearch(arr, start, mid -1, target);
    }

    // 4. Rotated binary Search => binary Search for rotated array...
    public int rotatedBinarySearch(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[start] <= arr[mid]){ // that means array is sorted...
            if(target >= arr[start] && target <= arr[mid]){
                return rotatedBinarySearch(arr, start, mid - 1, target);
            }else{
                return rotatedBinarySearch(arr, mid + 1, end, target);
            }
        }

        if(arr[mid] <= target && arr[end] >= target){
            return rotatedBinarySearch(arr, mid + 1, end , target);
        }
        return rotatedBinarySearch(arr, start, mid -1, target);
    }

    // 5. Bubble Sort
    public void bubbleSort(int[] arr, int row, int col){
        if(row < 1){
            return;
        }

        if(row > col){
            if(arr[col] > arr[col + 1]){
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        }
        else{
            bubbleSort(arr, row -1, 0);
        }
    }

    public void selectionSort(int[] arr, int row, int col, int max){
        if(row < 1){
            return;
        }

        if(row > col){
            if(arr[col] > arr[max]){
                max = col;
            }
            selectionSort(arr, row, col + 1, max);
        }else{
            int temp = arr[max];
            arr[max] = arr[col-1];
            arr[col-1] = temp;

            selectionSort(arr, row -1, 0, 0);
        }
    }

}
