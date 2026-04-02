class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int> maxD, minD;
        int left = 0, ans = 0;

        for (int right = 0; right < nums.size(); right++) {
            while (!maxD.empty() && nums[maxD.back()] < nums[right]) {
                maxD.pop_back();
            }
            while (!minD.empty() && nums[minD.back()] > nums[right]) {
                minD.pop_back();
            }

            maxD.push_back(right);
            minD.push_back(right);

            while (nums[maxD.front()] - nums[minD.front()] > limit) {
                if (maxD.front() == left) maxD.pop_front();
                if (minD.front() == left) minD.pop_front();
                left++;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};