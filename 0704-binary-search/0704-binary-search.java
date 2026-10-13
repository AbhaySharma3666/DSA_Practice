class Solution {
    public int findidx(int[] arr, int targ, int lo, int hi){
        if(lo>hi) return -1;
        int mid = lo + (hi-lo)/2;
        if (arr[mid] == targ) return mid;
        else if ( arr[mid]>targ) return findidx(arr,targ,lo,mid-1);
        else { return findidx(arr,targ,mid+1,hi);}
    }

    public int search(int[] nums, int target) {
       return findidx(nums,target,0,nums.length-1);
    }
}