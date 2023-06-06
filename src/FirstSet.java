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

}
