// power of two not work for negative number you dont assume -2^4==(-ve) its wrong we just use power not put -ve so only for postitve ones.

class Solution {
public:
    bool isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
};