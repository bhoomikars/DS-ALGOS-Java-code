public class QuickSort {
    public static int partition(int[] input, int l, int r){
        int i=l-1;
        int pivot = input[r];
        for(int j=l;j<r;j++){
            if(input[j]<=pivot){
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        i++;
        int temp = input[i];
        input[i] = input[r];
        input[r] = temp;
        return i;
    }

    public static void quickSort(int[] input, int l, int r){
        if(l<r){
            int q = partition(input,l,r);
            quickSort(input, l, q-1);
            quickSort(input, q+1, r);
        }
    }

    public static void quickSort(int[] input) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing output is handled automatically.
         */
        quickSort(input,0,input.length-1);
    }

    public static void main(String[] args){
        int[] input = {2,6,8,5,4,3};
        quickSort(input);
        for(int i=0;i<input.length;i++)
            System.out.print(input[i] + " ");
    }
}
