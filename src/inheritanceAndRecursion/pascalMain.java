package inheritanceAndRecursion;

import java.util.Scanner;

public class pascalMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rowNr = in.nextInt();
    }

    public static int[] pascalLine(int n) {
        if(n == 0)
            return new int[]{1};
        else if (n == 1)
            return new int[]{1,1};
        else
            return pascalLine(n-1);
    }
}
