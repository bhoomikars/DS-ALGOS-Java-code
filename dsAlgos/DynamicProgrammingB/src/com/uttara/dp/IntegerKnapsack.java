package com.uttara.dp;

public class IntegerKnapsack {
	
	private int[] weights;
    private  int[] profits;
    private int[][] solSpace;
    private int capacity;
    
    
    public IntegerKnapsack(int[] weights, int[] profits, int capacity) {
        this.weights = weights;
        this.profits = profits;
        this.capacity = capacity;
        int items = weights.length;
        solSpace = new int[items+1][capacity+1];

        for(int i=0; i<=items; i++)
            solSpace[i][0] = 0;
        for(int j=0; j<=capacity; j++)
            solSpace[0][j] = 0;
        for(int i=1; i<=items; i++)
            for(int j=1; j<=capacity; j++)
                solSpace[i][j] = -1;

    }
	
	//Integer Knapsack problem
    public  int intKnapsack(int i, int j){
        int p;
        if(solSpace[i][j]== -1){
            if(j<weights[i])
                p = intKnapsack(i-1, j);
            else {
                p = Math.max(intKnapsack(i-1, j), intKnapsack(i-1, j-weights[i])+profits[i]);
               }
            solSpace[i][j] = p;
        }
     return solSpace[i][j];
   }

    public void printSolMatrix() {
        for(int i=1; i<=weights.length; i++) {
            System.out.println();
                for(int j=1; j<=capacity; j++)
                System.out.print("  "+solSpace[i][j]);
        }
        System.out.println();
    }

    public void  printSolVector() {
        int[] lWeight = weights;
        int lCapacity = capacity;

        for(int i=(lWeight.length)-1; i>=1; i--) {

            if(solSpace[i][lCapacity] == solSpace[i-1][lCapacity-lWeight[i]] + profits[i] && lCapacity>=0) {
                lCapacity = lCapacity-lWeight[i];

                System.out.print(" " +i);

            }
        }

        System.out.println();
    }

    //Recursive Print Vector
    public void recPrintVector(int items, int capacity) {
        if(items < 1)
            return;
        else if(solSpace[items][capacity] == solSpace[items-1][capacity-weights[items]] + profits[items] && capacity>=0) {
            recPrintVector(items-1, capacity-weights[items]);
            System.out.print(" " +items);
            if(items == weights.length -1)
             System.out.println();
            return;
        }
        else {
            recPrintVector(items-1, capacity);
            if(items == weights.length -1)
             System.out.println();
            return;
        }

    }


}
