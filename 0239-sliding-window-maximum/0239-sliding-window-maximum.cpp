class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> dq; // store indices
        vector<int> ans;

        for (int i = 0; i < nums.size(); i++) {
            // Remove indices out of current window
            while (!dq.empty() && dq.front() <= i - k) {
                dq.pop_front();
            }

            // Maintain decreasing deque
            while (!dq.empty() && nums[dq.back()] < nums[i]) {
                dq.pop_back();
            }

            dq.push_back(i);

            // Start adding answers when first window is formed
            if (i >= k - 1) {
                ans.push_back(nums[dq.front()]);
            }
        }

        return ans;
    }
};