class Solution {
    public int firstMissingPositive(int[] arr) {
        int arrlen = arr.length;
        int i=0;
        while(i<arrlen){
            if( arr[i] > arrlen || 
                arr[i] < 1         ||
                arr[i] == arr[arr[i]-1] ||
                arr[i] == 0 
            ) i++;
            else swap(arr,i,arr[i]-1);
        }

        for(i=0;i<arrlen;i++){
            if(arr[i] != i+1) return i+1;
        }
        return arrlen + 1;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}