package dynamicProgramming;

import java.util.Scanner;
/**
 * 
 * @author olatunde
 * Given three sequences, find the longest common subsequence among them.
 *
 */
public class LongestCommonSubsequence {
        public static int CommonSubsequence(int[] s, int[] t, int[] f) {
            
            int n = s.length;
            int m = t.length; 
            int p = f.length;
            int[][][] D = new int[n + 1][m + 1][p + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++)
                    D[i][j][0] = 0;
            }
            for (int i = 0; i <= n; i++) {
                for (int k = 0; k <= p; k++)
                    D[i][0][k] = 0;
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= p; k++)
                    D[0][j][k] = 0;
            }
            
            for (int i = 1; i <= n; i++) {
                 for (int j = 1; j <= m; j++)  {
                     for (int k = 1; k <= p; k++)  {
                         int first = D[i][j - 1][k];
                         int sec  = D[i - 1][j][k];
                         int thd  = D[i][j][k - 1];
                         int four  = D[i][j - 1][k - 1];
                         int fif  = D[i - 1][j][k - 1];
                         int six  = D[i - 1][j - 1][k];
                         int mismatch = D[i - 1][j - 1][k - 1];
                         int match = D[i - 1][j - 1][k - 1] + 1;
                         int maximum;
                     
                         if(s[i - 1] == t[j - 1] && s[i - 1] == f[k - 1])
                             maximum = Math.max(match, Math.max(six, Math.max(fif, Math.max(four, Math.max(thd, Math.max(first, sec))))));
                         else
                             maximum = Math.max(mismatch, Math.max(six, Math.max(fif, Math.max(four, Math.max(thd, Math.max(first, sec))))));
                         D[i][j][k] = maximum; 
                     }
                      
                 }
            }
          return D[n][m][p];
        }
        
        public static void main(String args[]) {
          Scanner scan = new Scanner(System.in);

          int n = scan.nextInt();
          int[] s = new int[n];
          for(int i = 0; i < n; i++)
              s[i] = scan.nextInt();
          int m = scan.nextInt();
          int[] t = new int[m];
          for(int i = 0; i < m; i++)
              t[i] = scan.nextInt();
          int p = scan.nextInt();
          int[] f = new int[p];
          for (int i = 0; i < p; i++)
              f[i] = scan.nextInt();

          System.out.println(CommonSubsequence(s, t, f));
          scan.close();
        }

}
