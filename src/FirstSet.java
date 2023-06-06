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

}
