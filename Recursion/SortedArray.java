public class SortedArray {
    public static int num=0;
    public static void main(String[] args){
        int[] arr = {2,4,6,7,8};
        System.out.println(sortedOrNot(arr));
    }
//    public static boolean sortedOrNot(int[] arr){
//        if(num == arr.length-1)
//            return true;
//        if(arr[num] > arr[++num])
//            return false;
//        return sortedOrNot(arr);
//    }
    public static boolean sortedOrNot(int[] arr){
        if(arr.length<=1)
            return true;
        int smallInput[] = new int[arr.length - 1];
        for(int i=1;i<arr.length;i++)
            smallInput[i-1] = arr[i];
        boolean ans = sortedOrNot(smallInput);
        if(!ans)
            return false;
        if(arr[0]<=arr[1])
            return true;
        else
            return false;
    }
}
