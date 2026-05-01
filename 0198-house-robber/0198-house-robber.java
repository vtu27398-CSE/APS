class Solution {
    public int rob(int[] nums) {
        int prev1 = 0; // max till previous house
        int prev2 = 0; // max till house before previous

        for (int num : nums) {
            int take = prev2 + num;
            int skip = prev1;

            int cur = Math.max(take, skip);

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}