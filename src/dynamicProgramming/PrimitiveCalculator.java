package dynamicProgramming;

import java.util.*;

/**
 * 
 * @author olatunde
 * The program involves a calculator that performs only three operations:
 * Addition of 1,and multiplication by 2, or 3.
 * A list storing the minimum number of ways to reach a number from 1
 *
 */
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
    	List<Integer> sequence = new ArrayList<Integer>();
        int[] C = new int[n + 1];
        C[0] = 0;
        C[1] = 0;
        for (int i = 2; i <= n; i++) {
        	C[i] = C[i - 1] + 1;
        	int tmp;
        	
        	if (i % 2 == 0) {
        		tmp = C[i / 2] + 1;
        	    if (tmp < C[i])
        	    	C[i] = tmp;
        	}
        	
            if (i % 3 == 0) {
        		tmp = C[i / 3] + 1;
        		if (tmp < C[i])
        			C[i] = tmp;
        	}
        
        }
   
         while (n  >= 1){
        	sequence.add(n);
        	if (C[n] == 0)
        		break;
        	if(C[n - 1] == C[n] - 1)
        	    n -= 1;
            
        	else if(n % 2 == 0 && C[n / 2] == C[n] - 1)
            	 n /= 2;
        	
        	else if(n % 3 == 0 && C[n / 3] == C[n] - 1)
            	n /= 3;
            
        }
        
        Collections.reverse(sequence);
        return sequence;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

}

 