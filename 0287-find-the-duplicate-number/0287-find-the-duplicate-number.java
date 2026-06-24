class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            if(nums[i]<n+1 && nums[i] != i+1){
                if(nums[i] == nums[nums[i]-1]) return nums[i];

                swap(nums,i,nums[i]-1);
            } else i++;
        }
        return n;
    }
    public void swap(int[] arr, int i, int idx){
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx]=temp;
    }
}