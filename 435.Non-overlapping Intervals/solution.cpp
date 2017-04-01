/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    int eraseOverlapIntervals(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [](Interval a, Interval b) {
            return a.start == b.start ? a.end < b.end : a.start < b.start;
        });
        int ans = 0;
        auto it = intervals.begin();
        while (it != intervals.end()) {
            it++;
            while (it != intervals.end() && (*it).start >= (*(it-1)).start && (*it).start < (*(it-1)).end) {
                if ((*it).end <= (*(it-1)).end) {
                    *(it-1) = *it;
                }
                it = intervals.erase(it);
                ans++;
            }
        }
        return ans;
    }
};
