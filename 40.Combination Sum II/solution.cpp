class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int > vt;
        for (int i = 0; i < candidates.size(); i++) {
            vt.push_back(candidates[i]);
            dfs(i + 1, target - candidates[i], candidates, vt);
            vt.pop_back();
        }
        vector<vector<int> > ans(st.begin(), st.end());
        return ans;
    }
    
    void dfs(int pos, int target, vector<int>& candidates, vector<int>& vt) {
        if (target <= 0) {
            if (target == 0) {
                st.insert(vt);
            }
            return;
        }
        for (int i = pos; i < candidates.size(); i++) {
            vt.push_back(candidates[i]);
            dfs(i + 1, target - candidates[i], candidates, vt);
            vt.pop_back();
        }
    }
    
    set<vector<int> >st;
};
