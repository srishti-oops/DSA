class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maxelem(nums);
        int ans = -1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            int sum = 0;
            for(int i =0; i < nums.length; i++){
            sum += (nums[i]+mid-1)/mid;
            }
            if(sum <= threshold){
                ans = mid;
                high = mid-1;
            }
            else
            low = mid+1;
        }
        return ans;
    }
    public int maxelem(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]> max)
            max = nums[i];
        }
        return max;
    }
}