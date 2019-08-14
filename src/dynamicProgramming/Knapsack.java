package dynamicProgramming;
import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
    	int[][] value = new int[W + 1][w.length + 1];
    	for (int i = 0; i < w.length; i++) 
    		value[0][i] = 0;
    	for (int i = 0; i < W; i++)
    		value[i][0] = 0;
    	
    	for (int item = 1; item <= w.length; item++)  {
    		for (int weight = 1; weight <= W; weight++)  {
    			  value[weight][item] = value[weight][item - 1];
    			  if(w[item - 1] <= weight) {
    				  int val = value[weight - w[item - 1]][item - 1] + w[item - 1];
    				  if (val > value[weight][item])
    					  value[weight][item] = val;
    			  }
    		}
    	}
        return value[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


