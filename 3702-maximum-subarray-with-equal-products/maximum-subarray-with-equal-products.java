class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            long currentProduct = 1;
            long currentGcd = nums[i];
            long currentLcm = nums[i];

            for (int j = i; j < n; j++) {
                currentProduct *= nums[j];
                currentGcd = gcd(currentGcd, nums[j]);
                currentLcm = lcm(currentLcm, nums[j]);
                if (currentProduct > currentLcm * currentGcd) {
                    
                }
                if (currentProduct == currentLcm * currentGcd) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }
}