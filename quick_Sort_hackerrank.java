import java.io.*;
import java.util.*;

public class Solution {
    public static int parti(int[] arr,int s,int l){
        int i = s-1;
        int pivot = arr[l];
        for(int j = s;j<l;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[l] = temp;
        return i;
    }
    public static void quick(int[] arr,int s,int l){
        if(s<l){
            int pidx = parti(arr,s,l);
            for(int i = 0;i<arr.length-1;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println(arr[arr.length-1]);
            quick(arr,s,pidx-1);
            quick(arr,pidx+1,l);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        quick(arr,0,n-1);
    }
}
