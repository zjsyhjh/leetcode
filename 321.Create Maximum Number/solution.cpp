class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int > ans(k, 0);
        for (int i = max(0, k - (int)nums2.size()); i <= min(k, (int)nums1.size()); i++) {
            vector<int > vt1 = get_max_subarray(nums1, i);
            vector<int > vt2 = get_max_subarray(nums2, k - i);
            vector<int > vt;
            int pos1 = 0, pos2 = 0;
            while (pos1 < vt1.size() || pos2 < vt2.size()) {
                int num = greater(vt1, pos1, vt2, pos2) ? vt1[pos1++] : vt2[pos2++];
                vt.push_back(num);
            }
            if (greater(vt, 0, ans, 0)) {
                ans = vt;
            }
        }
        return ans;    
    }
    
    vector<int > get_max_subarray(vector<int>&a, int k) {
        vector<int > res(k, 0);
        int l = 0, n = a.size();
        for (int i = 0; i < n; i++) {
            while (l > 0 && l + n - i > k && a[i] > res[l - 1]) l--;
            if (l < k) res[l++] = a[i];
        }
        return res;
    }

    bool greater(vector<int >&a, int pos1, vector<int>&b, int pos2) {
        while (pos1 < a.size() && pos2 < b.size() && a[pos1] == b[pos2]) {
            pos1++;
            pos2++;
        }
        return pos2 == b.size() || (pos1 < a.size() && a[pos1] > b[pos2]);
    }
};

