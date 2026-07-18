class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int i= 0; i< weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int ans= Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low+high)/2;
            int reqdays = 1;
            int load = 0;
            for(int i = 0; i< weights.length; i++){
                if(load + weights[i] <= mid){
                    load += weights[i];
                }
                else{
                reqdays++;
                load = weights[i];
                }
            }
            if(reqdays <= days){
                ans = mid;
                high = mid-1;
            }
            else
            low = mid+1;
        }
        return ans;
    }
}