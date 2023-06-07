import java.util.ArrayList;

public class FirstSet {
    // 1. Print Name 5 Times
    public void printName5Times(String name, int n){
        // base condition
        if(n == 0){
            return;
        }
        // Printing the name here...
        System.out.println(name);

        // Recursion Call
        printName5Times(name, n-1);
    }

    // 2.Print Linearly from 1 T0 N
    public void printLinearlyFrom1ToN(int n){
        // base condition
        if(n < 1){
            return;
        }
        // calling recursive function until base condition returns false
        printLinearlyFrom1ToN(n-1);

        // printing values of n in the end...
        System.out.println(n);
    }
    // 3. Print Numbers from N to 1
    public void printFromNto1(int n){
        // base condition
        if(n < 1){
            return;
        }

        // In this case printing values first as we are going to print values from n
        System.out.println(n);

        // calling function recursively...
        printFromNto1(n-1);
    }

    // 4. Print Sum from 1 To N
    public void printSumNSum(int num, int sum, int n){
        // base condition
        if(num > n){
            // printing sum
            System.out.println(sum);
            return;
        }

        // sum
        sum += num;
        // calling recursive funtion...
        printSumNSum(num + 1, sum , n);
    }

    // 5. print values from 1 to n by returning value
    public int printReturnSum(int num){
        // base condition
        if(num < 1){
            return 0;
        }

        // adding values of n to the recursive function.. => 5 + fn -> 4 + fn -> 3 + fn
        return num +  printReturnSum(num -1);
    }

    //6. Factorial of a Number
    public int factorial(int n){
        if(n<1){
            return 1;
        }
        return n * factorial(n-1);
    }

    // 7. Reverse an Array in a new ArrayList
    public void reverseArray(int[] arr, int i, ArrayList<Integer> list){
        if(i == arr.length){
            return;
        }
        reverseArray(arr, i+1, list);
        list.add(arr[i]);
    }

    // 8. reverse an Array => In place reversal using swapping
    public void reverseSwapArray(int[] arr, int i, int n){
        // base condition if pointer is greater than or equal to the middle of the array
        if(i >= n/2){
            return;
        }

        // swapping first and last element
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;

        // calling recursive function...
        reverseSwapArray(arr, i+1, n);
    }

    // 9. Reverse a String
    public String reverseString(String str){
        if (str.isEmpty()) {
            return str;
        } else {
            String ans =  reverseString(str.substring(1)) + str.charAt(0);
            return ans;
        }
    }

    // 10. Check whether the given array is sorted or not
    public boolean isSorted(int[] arr, int i){
        // base condition -> the pointer should not be greater than the length of the array.
        if(i >= arr.length-1){
            return true;
        }

        // checks if the first element is greater than the next element.
        if(arr[i] > arr[i+1]){
            return false;
        }

        // retuning recursive funtion
        return isSorted(arr, i+1);
    }

    // 11. Reverse a Number using recursion
    public int reverseNumber(int num){
        // base condition -> if number is less than 10 then return
        if(num < 10){
            return num;
        }

        int lastdigit = num % 10; // find the last digit
        int remainingdigits = num /10; // remove the last digit
        int reversedNumber = reverseNumber(remainingdigits); // recursive call
        int numOfDigits = (int) Math.log10(remainingdigits) + 1; // num of digits
        return (lastdigit * (int)Math.pow(10, numOfDigits)) + reversedNumber; // eg 3 x 100 + 21 -> format to reverse the number
    }

}
