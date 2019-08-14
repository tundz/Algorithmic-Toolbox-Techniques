package dynamicProgramming;
import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
      
	  int n = s.length();
	  int m = t.length(); 
	  int[][] D = new int[n + 1][m + 1];
	  for (int i = 0; i <= n; i++)
		  D[i][0] = i;
	  for (int j = 1; j <= m; j++)
		  D[0][j] = j;
	  
	  
	  
	  for (int i = 1; i <= n; i++) {
		   for (int j = 1; j <= m; j++)  {
			   int insertion = D[i][j - 1] + 1;
			   int deletion  = D[i - 1][j] + 1;
			   int mismatch = D[i - 1][j - 1] + 1;
			   int match = D[i - 1][j - 1];
			   int minimum;
			   
			   if(s.charAt(i - 1) == t.charAt(j - 1))
				   minimum = Math.min(insertion, Math.min(deletion, match));
			   else
				   minimum = Math.min(insertion, Math.min(deletion, mismatch));
				D[i][j] = minimum; 
				
		   }
	  }
    return D[n][m];
  }
  
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    scan.useDelimiter(",");
    String s = scan.next();
    String t = scan.next();
    System.out.println(s);
    System.out.println(t);
    //System.out.println(EditDistance(s, t));
    scan.close();
  }

}
