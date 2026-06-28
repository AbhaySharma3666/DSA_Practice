class Solution {
    public int[] findErrorNums(int[] arr) {
        int arrlen = arr.length;
        int i=0;
        // Cyclic Sort - Place each number at its correct index (arr[i]-1)
        while(i<arrlen){
            // Check if the number is already in the correct position
            // If not, swap it
            if( arr[i] != arr[arr[i]-1] ) {
                swap(arr,i,arr[i]-1);
            } else i++;
        }
        // arr[i] is the duplicate, (i + 1) is the missing number
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