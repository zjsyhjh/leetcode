class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        vector<int > tmp, res(nums.size());
        for (int i = nums.size() - 1; i >= 0; i--) {
            int d = distance(tmp.begin(), lower_bound(tmp.begin(), tmp.end(), nums[i]));
            res[i] = d;
            tmp.insert(tmp.begin() + d, nums[i]);
        }
        return res;
    }
};
