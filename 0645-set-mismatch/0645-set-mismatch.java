class Solution {
    public int[] findErrorNums(int[] arr) {
        int arrlen = arr.length;
        int i=0;
        while(i<arrlen){
            if( arr[i] != arr[arr[i]-1] ) {
                swap(arr,i,arr[i]-1);
            } else i++;
        }
        for(i=0 ; i<arrlen ; i++){
            if(arr[i] != i+1){
                return new int[]{arr[i], i + 1};
            }
        }
        return new int[0];
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}