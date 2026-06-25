class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        while(i<n){
            int rightIdx = arr[i] - 1;
            if(arr[i]==i+1 || arr[rightIdx] == arr[i]) i++;
            else swap(arr,i,rightIdx);
        }
        for(i=0;i<n;i++){
            if(arr[i] != i+1) ans.add(i+1);
        }
        return ans;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}