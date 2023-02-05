import java.io.*;
import java.util.*;

public class Solution {
    public static void merge(int[] arr,int s,int mid,int l){
        int mer[] = new int[l-s+1];
        int i = s,k=0,j=mid+1;
        while(i<=mid && j<=l){
            if(arr[i]<arr[j]){
                mer[k++] = arr[i++];
            }else{
                mer[k++] = arr[j++];
            }
        }
        while(i<=mid){
            mer[k++] = arr[i++];
        }
        while(j<=l){
            mer[k++] = arr[j++];
        }
        for(int a = 0,b = s;a<mer.length;a++,b++){
            arr[b] = mer[a];
        }
    }
    public static void divide(int[] arr,int s,int l){
        if(s<l){
            int mid = s+(l-s)/2;
            divide(arr,s,mid);
            divide(arr,mid+1,l);
            merge(arr,s,mid,l);
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
        divide(arr,0,n-1);
        
        System.out.print("["+arr[0]);
        for(int i = 1;i<n;i++){
            System.out.print(","+arr[i]);
        }
        System.out.print("]");     
    }
}
