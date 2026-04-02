class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        int n = prices.size();
        stack<int> st; // store indices

        for (int i = 0; i < n; i++) {
            while (!st.empty() && prices[st.top()] >= prices[i]) {
                prices[st.top()] -= prices[i];
                st.pop();
            }
            st.push(i);
        }

        return prices;
    }
};