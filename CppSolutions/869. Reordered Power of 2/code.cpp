// max range in question is 10^9, so we only need to check powers of 2 up to 2^30


class Solution {
public:
    
    bool reorderedPowerOf2(int n) {
        string s = to_string(n);
        sort(s.begin(), s.end());

        for (int i = 0; i < 31; i++) {
            int pow2 = 1 << i;
            string p = to_string(pow2);
            sort(p.begin(), p.end());
            if (s == p) return true;
        }
        return false;
    }
};