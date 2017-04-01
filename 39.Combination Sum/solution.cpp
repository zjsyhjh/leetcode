class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int > vt;
        for (int i = 0; i < candidates.size(); i++) {
            vt.push_back(candidates[i]);
            dfs(i, target - candidates[i], candidates, vt);
            vt.pop_back();
        }
        return ans;
    }
    
    void dfs(int pos, int target, vector<int>& candidates, vector<int>& vt) {
        if (target <= 0) {
            if (target == 0) {
                ans.push_back(vt);
            }
            return;
        }
        for (int i = pos; i < candidates.size(); i++) {
            vt.push_back(candidates[i]);
            dfs(i, target - candidates[i], candidates, vt);
            vt.pop_back();
        }
    }
    
    vector<vector<int> >ans;
};
