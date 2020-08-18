import java.io.BufferedReader;
import java.io.IOException;

import java.io.*;

public class GFG {
    // Driver Code
    public static void main(String[] args) throws IOException
    {

        // Using BufferedReader class to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // n : size of array
            int n = Integer.parseInt(br.readLine());

            // Declaring array
            int arr[] = new int[n];

            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            // array elements input
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(strs[i]);

            // Calling Functions to segregate Array elements
            segragateArr(arr, n);

            // Using string buffer to append each output in a string
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");

            // finally printing the string
            System.out.println(sb);
        }
        br.close();
    }

    // Function to segragate 0s, 1s and 2s
    public static void segragateArr(int arr[], int n)
    {
        /*
        low : to keep left index
        high : to keep right index
        mid : to get middle element
        */
        int low = 0, high = n - 1, mid = 0;

        // Iterating through the array and
        // segregating elements
        while (mid <= high) {

            // If element at mid is 0
            // move it to left
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }

            // If element at mid is 1
            // nothing to do
            else if (arr[mid] == 1) {
                mid++;
            }

            // If element at mid is 2
            // move it to last
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
