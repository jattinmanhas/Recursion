import java.util.ArrayList;
import java.util.Arrays;

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

    // 6. Selection Sort using Recursion
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

    // 7. Merge Sort....
    // a. Merge sort => sorting in different array

    public int[] mergeSortOther(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        // dividing arrays
        int[] left = mergeSortOther(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSortOther(Arrays.copyOfRange(arr, mid , arr.length));

        return mergeOther(left, right);
    }

    // merging arrays and sorting
    public int[] mergeOther(int[] left, int[] right){
        int[] newArray = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                newArray[k] = left[i];
                i++; k++;
            }else{
                newArray[k] = right[j];
                j++; k++;
            }
        }

        while(i < left.length){
            newArray[k] = left[i];
            i++; k++;
        }
        while(j < right.length){
            newArray[k] = right[j];
            j++; k++;
        }

        return newArray;
    }

    // b. Merge sort => sorting in the original array
    public void mergeSortInPlace(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    public void mergeInPlace(int[] arr, int start, int mid , int end){
        int[] newArray = new int[end-start];
        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j<end){
            if(arr[i] < arr[j]){
                newArray[k] = arr[i];
                i++; k++;
            }else{
                newArray[k] = arr[j];
                j++; k++;
            }
        }

        while(i < mid){
            newArray[k] = arr[i];
            i++; k++;
        }
        while(j < end){
            newArray[k] = arr[j];
            j++; k++;
        }

        for(int l = 0;l<newArray.length;l++){
            arr[start + l] = newArray[l];
        }
    }

    //
    public void quickSort(int[] arr, int low, int high){
        if(high > low){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi -1);
            quickSort(arr, pi+1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];

        int i = low -1;
        for(int j = low; j<= arr.length-1; j++){
            if(pivot > arr[j]){
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return (i+1);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
