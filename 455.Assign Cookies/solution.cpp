#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        vector<int >::iterator iter_g = g.begin();
        vector<int >::iterator iter_s = s.begin();
        int res = 0;
        while (iter_g != g.end() && iter_s != s.end()) {
            if (*iter_g <= *iter_s) {
                iter_g++;
                iter_s++;
                res++;
            } else {
                iter_s++;
            }
        }
        return res;
    }
};
