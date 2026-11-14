class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + l - 1; j < Math.min(n, i + r); j++) {
                int currentSum = prefix[j + 1] - prefix[i];
                if (currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}