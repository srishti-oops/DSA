class Solution {
    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE1 = 100_003L;
    static final long BASE2 = 100_009L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (hasUnique(nums, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private boolean hasUnique(int[] nums, int len) {
        int n = nums.length;
        long pow1 = 1, pow2 = 1;
        for (int i = 0; i < len; i++) {
            pow1 = pow1 * BASE1 % MOD1;
            pow2 = pow2 * BASE2 % MOD2;
        }
        long h1 = 0, h2 = 0;
        for (int i = 0; i < len; i++) {
            h1 = (h1 * BASE1 + nums[i]) % MOD1;
            h2 = (h2 * BASE2 + nums[i]) % MOD2;
        }
        HashMap<Long, Integer> cnt = new HashMap<>((n - len + 1) * 2);
        cnt.merge(pack(h1, h2), 1, Integer::sum);
        for (int i = 1; i <= n - len; i++) {
            h1 = ((h1 * BASE1 + nums[i + len - 1] - nums[i - 1] * pow1) % MOD1 + MOD1) % MOD1;
            h2 = ((h2 * BASE2 + nums[i + len - 1] - nums[i - 1] * pow2) % MOD2 + MOD2) % MOD2;
            cnt.merge(pack(h1, h2), 1, Integer::sum);
        }
        for (int c : cnt.values()) if (c == 1) return true;
        return false;
    }

    private long pack(long a, long b) {
        return (a << 32) ^ (b & 0xffffffffL); 
    }
}