import java.util.Arrays;

class Solution {
    private void mergeSort(int arr[], int low, int high){
        if(low < high ){
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int arr[], int low, int mid, int high){
        int leng1 = mid - low + 1;
        int leng2 = high - mid;

        int arr1[] = new int[leng1];
        int arr2[] = new int[leng2];

        
        for(int i = 0; i < leng1; i++) arr1[i] = arr[low + i]; 
        for(int i = 0; i < leng2; i++) arr2[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low;

        while(i < leng1 && j < leng2){
            if(arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        while(i < leng1) arr[k++] = arr1[i++];
        while(j < leng2) arr[k++] = arr2[j++];
    }

    public int[] sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }  
}