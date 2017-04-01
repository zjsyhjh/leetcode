class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<int > vt;
        for (int num = 1; num <= 9; num++) {
            vt.push_back(num);
            dfs(num + 1, k - 1, n - num, vt);
            vt.pop_back();
        }
        return ans;
    }
    void dfs(int pos, int k, int target, vector<int>& vt) {
        if (k <= 0) {
            if (k == 0 && target == 0) {
                ans.push_back(vt);
            }
            return;
        }
        for (int num = pos; num <= 9; num++) {
            vt.push_back(num);
            dfs(num + 1, k - 1, target - num, vt);
            vt.pop_back();
        }
    }
    vector<vector<int> > ans;
};
