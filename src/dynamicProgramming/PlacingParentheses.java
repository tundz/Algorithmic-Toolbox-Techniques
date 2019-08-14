package dynamicProgramming;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      long[][] m = new long[(exp.length() / 2) + 1][(exp.length() / 2) + 1];
      long[][] M = new long[(exp.length() / 2) + 1][(exp.length() / 2) + 1];
      
      long n = M.length;
      //Populate all m(i,i) with the corresponding integers at the points.
      for (int i = 0; i < n; i++)  {
           m[i][i] = Integer.parseInt(exp.substring(i *2, i *2 + 1));
           M[i][i] = Integer.parseInt(exp.substring(i *2, i *2 + 1));
      }
      int j;
      for (int s = 1; s <= n - 1; s++) {
          for (int i = 0; i < n -s; i++) {
              j = i + s;
              minAndMax(i , j, m, M, exp);
          }
      }
      return M[0][(int) (n -1)];
    }
    
    private static void minAndMax (int i, int j, long[][]m, long[][]M, String x)  {
        long min = (long) Double.POSITIVE_INFINITY;
        long max = (long) Double.NEGATIVE_INFINITY;
         for (int k = i; k < j; k++)  {
             long a, b, c, d;
             
             a = eval (M[i][k], M[k+1][j], x.charAt(2 * k + 1));
             b = eval (M[i][k], m[k+1][j], x.charAt(2 * k + 1));
             c = eval (m[i][k], M[k+1][j], x.charAt(2 * k + 1));
             d = eval (m[i][k], m[k+1][j], x.charAt(2 * k + 1));
             min = Math.min(Math.min(a, b),  Math.min(Math.min(c, d), min));
             max = Math.max(Math.max(a, b),  Math.max(Math.max(c, d), max));
         }
         m[i][j] = min;
         M[i][j] = max;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
        scanner.close();
    }
}


