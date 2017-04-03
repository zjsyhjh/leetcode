class NumArray {
public:
    NumArray(vector<int> nums) {
        if (nums.size() == 0) {
            return;
        }
        sum = vector<int >(nums.size() << 2, 0);
        L = 0;
        R = nums.size() - 1;
        build(1, L, R, nums);
    }
    
    void update(int i, int val) {
        update(1, L, R, i, val);
    }
    
    int sumRange(int i, int j) {
        return query(i, j, 1, L, R);
    }
    
    void update(int rt, int L, int R, int i, int val) {
        if (L == i && R == i) {
            sum[rt] = val;
            return;
        }
        int M = (L + R) >> 1;
        if (i <= M) update(rt << 1, L, M, i, val);
        else update(rt << 1 | 1, M + 1, R, i, val);
        push_up(rt);
    }
    
    int query(int i, int j, int rt, int L, int R) {
        if (i == L && j == R) {
            return sum[rt];
        }
        int M = (L + R) >> 1;
        int res = 0;
        if (j <= M) res += query(i, j, rt << 1, L, M);
        else if (i > M) res += query(i, j, rt << 1 | 1, M + 1, R);
        else {
            res += query(i, M, rt << 1, L, M);
            res += query(M + 1, j, rt << 1 | 1, M + 1, R);
        }
        return res;
    }
    
    void build(int rt, int L, int R, vector<int>& nums) {
        if (L == R) {
            sum[rt] = nums[L];
            return;
        }
        int mid = (L + R) >> 1;
        build(rt << 1, L, mid, nums);
        build(rt << 1 | 1, mid + 1, R, nums);
        push_up(rt);
    }
    
    void push_up(int rt) {
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }
private:
    int L, R;
    vector<int > sum;
}; 


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
