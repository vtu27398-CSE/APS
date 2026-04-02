class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int j = 0; // position for next non-zero
        
        // Move all non-zero elements forward
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        // Fill remaining positions with zero
        while (j < nums.size()) {
            nums[j++] = 0;
        }
    }
};